DROP PROCEDURE IF EXISTS SafeTransferFunds;
DELIMITER $$

CREATE PROCEDURE SafeTransferFunds
( IN p_sourceAcct  INT,
  IN p_targetAcct  INT,
  IN p_amount      DECIMAL(10,2) )
BEGIN
    DECLARE v_sourceBal DECIMAL(10,2);

    -- Error handler
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        INSERT INTO AuditLog (Severity, Location, Message)
        VALUES ('ERROR','SafeTransferFunds', CONCAT('FAILED transfer ',
               p_amount,' from ',p_sourceAcct,' to ',p_targetAcct,
               ' – possible error during transaction'));
    END;

    START TRANSACTION;

    -- 1. Get balance
    SELECT Balance INTO v_sourceBal
    FROM   Accounts
    WHERE  AccountID = p_sourceAcct
    FOR UPDATE;

    -- 2. Check balance
    IF v_sourceBal < p_amount THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient funds';
    END IF;

    -- 3. Transfer
    UPDATE Accounts SET Balance = Balance - p_amount
    WHERE  AccountID = p_sourceAcct;

    UPDATE Accounts SET Balance = Balance + p_amount
    WHERE  AccountID = p_targetAcct;

    COMMIT;

    -- 4. Success log
    INSERT INTO AuditLog (Severity, Location, Message)
    VALUES ('INFO','SafeTransferFunds',
            CONCAT('SUCCESS – ',p_amount,' transferred from ',
                   p_sourceAcct,' to ',p_targetAcct));
END$$
DELIMITER ;

DROP TABLE IF EXISTS AuditLog;

CREATE TABLE AuditLog (
    LogID     INT AUTO_INCREMENT PRIMARY KEY,
    LogDate   DATETIME      DEFAULT CURRENT_TIMESTAMP,
    Severity  ENUM('INFO','ERROR')  DEFAULT 'ERROR',
    Location  VARCHAR(50),
    Message   TEXT
);


-- Test: working case
CALL SafeTransferFunds(1, 2, 200);

-- Test: insufficient balance
CALL SafeTransferFunds(1, 2, 999999);

-- Check balances
SELECT * FROM Accounts;

-- Check log
SELECT * FROM AuditLog ORDER BY LogID DESC;
