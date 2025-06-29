DROP FUNCTION IF EXISTS HasSufficientBalance;
DELIMITER $$

CREATE FUNCTION HasSufficientBalance(
    p_accountID INT,
    p_amount DECIMAL(10,2)
)
RETURNS BOOLEAN
DETERMINISTIC
BEGIN
    DECLARE current_balance DECIMAL(10,2);

    SELECT Balance INTO current_balance
    FROM Accounts
    WHERE AccountID = p_accountID;

    RETURN current_balance >= p_amount;
END$$

DELIMITER ;

SET @min_amount := 500;

-- HasSuffienct Balance
SELECT 
    c.CustomerID,
    c.Name,
    a.AccountID,
    a.Balance AS CurrentBalance,
    @min_amount AS RequiredAmount,
    HasSufficientBalance(a.AccountID, @min_amount) AS HasSufficientBalance
FROM 
    Customers c
JOIN 
    Accounts a ON c.CustomerID = a.CustomerID
ORDER BY 
    c.CustomerID, a.AccountID;
