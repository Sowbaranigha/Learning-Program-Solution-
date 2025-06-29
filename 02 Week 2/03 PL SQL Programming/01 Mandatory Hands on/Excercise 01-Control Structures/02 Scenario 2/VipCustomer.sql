DELIMITER $$

CREATE PROCEDURE PromoteVIPCustomers()
BEGIN
    UPDATE Customers  AS c
    JOIN   Customers  AS t   ON t.CustomerID = c.CustomerID
    SET    c.IsVIP = TRUE
    WHERE  t.Balance > 10000;      -- t.CustomerID in the JOIN satisfies Safe Update
END$$
DELIMITER ;

-- 1. List everyone with balance > 10,000
SELECT CustomerID, Name, Balance
FROM   Customers
WHERE  Balance > 10000;

-- 2. Check VIP flag status for every customer
SELECT CustomerID, Name, Balance, IsVIP
FROM   Customers
ORDER BY Balance DESC;

