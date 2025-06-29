DROP PROCEDURE IF EXISTS TransferFunds;
DELIMITER $$

CREATE PROCEDURE TransferFunds(
    IN p_fromAcct INT,
    IN p_toAcct   INT,
    IN p_amount   DECIMAL(10,2)
)
BEGIN
    DECLARE v_balance DECIMAL(10,2);

    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        SELECT 'Error: Transfer failed, transaction rolled back' AS Message;
    END;

    START TRANSACTION;

    SELECT Balance INTO v_balance
    FROM Accounts
    WHERE AccountID = p_fromAcct
    FOR UPDATE;

    IF v_balance < p_amount THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Insufficient funds';
    END IF;

    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_fromAcct;

    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_toAcct;

    COMMIT;

    SELECT 'Transfer successful' AS Message;
END$$

DELIMITER ;

-- Transfer ₹500 from account 1 to 2
CALL TransferFunds(1, 2, 500);

-- View updated balances
SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (1, 2);

