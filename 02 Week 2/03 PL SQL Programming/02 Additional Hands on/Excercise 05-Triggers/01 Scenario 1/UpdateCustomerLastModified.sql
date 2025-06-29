DELIMITER $$

CREATE TRIGGER UpdateCustomerLastModified
BEFORE UPDATE ON Customers
FOR EACH ROW
BEGIN
    SET NEW.LastModified = CURDATE();
END$$

DELIMITER ;

-- Update Customer Last Modified
UPDATE Customers SET Balance = Balance + 100 WHERE CustomerID = 1;
SELECT * FROM Customers WHERE CustomerID = 1;
