DROP PROCEDURE IF EXISTS ProcessMonthlyInterest;
DELIMITER $$

CREATE PROCEDURE ProcessMonthlyInterest()
BEGIN
    UPDATE Accounts
    SET Balance = Balance * 1.01
    WHERE AccountType = 'Savings';
END$$

DELIMITER ;

-- Indentifying Savings Account
SET SQL_SAFE_UPDATES = 0;

CALL ProcessMonthlyInterest();
SELECT * FROM Accounts WHERE AccountType = 'Savings';

