DROP PROCEDURE IF EXISTS ApplyAnnualFee;
DELIMITER $$

CREATE PROCEDURE ApplyAnnualFee(IN p_fee DECIMAL(10,2))
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_acct INT;

    DECLARE curAcct CURSOR FOR SELECT AccountID FROM Accounts;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN curAcct;
    LOOP_ACCTS: LOOP
        FETCH curAcct INTO v_acct;
        IF done THEN LEAVE LOOP_ACCTS; END IF;

        UPDATE Accounts
        SET Balance = Balance - p_fee
        WHERE AccountID = v_acct;
    END LOOP;
    CLOSE curAcct;
END$$
DELIMITER ;

-- calling the ApplyAnnualFee
CALL ApplyAnnualFee(200);

-- Verify a few balances
SELECT AccountID, Balance FROM Accounts LIMIT 5;

