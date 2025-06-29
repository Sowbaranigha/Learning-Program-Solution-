DROP FUNCTION IF EXISTS acct_total_balance;
DELIMITER $$

CREATE FUNCTION acc_total_balance(p_customerID INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE total DECIMAL(10,2);

    SELECT SUM(Balance)
    INTO total
    FROM Accounts
    WHERE CustomerID = p_customerID;

    RETURN IFNULL(total, 0);
END$$

DELIMITER ;

-- Verfying Account Balance
SELECT acc_total_balance(3) AS TotalBalance;
-- Check Manually
SELECT SUM(Balance) AS ActualTotal FROM Accounts WHERE CustomerID = 3;

