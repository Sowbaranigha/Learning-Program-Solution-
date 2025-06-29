DROP PROCEDURE IF EXISTS AddNewCustomer;
DELIMITER $$

CREATE PROCEDURE AddNewCustomer
( IN p_customerID INT,
  IN p_name       VARCHAR(100),
  IN p_dob        DATE,
  IN p_balance    DECIMAL(10,2) )
BEGIN
    /* Handle only duplicate‑key errors */
    DECLARE CONTINUE HANDLER FOR 1062
        INSERT INTO AuditLog (Severity, Location, Message)
        VALUES ('ERROR','AddNewCustomer',
                CONCAT('Duplicate CustomerID ',p_customerID));

    INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
    VALUES (p_customerID, p_name, p_dob, p_balance, CURDATE());

    INSERT INTO AuditLog (Severity, Location, Message)
    VALUES ('INFO','AddNewCustomer',
            CONCAT('Customer ',p_customerID,' inserted OK'));
END$$
DELIMITER ;

-- Fresh ID (works)
CALL AddNewCustomer(20,'Neha Sharma','1995-03-12',2500);

-- Duplicate ID (logs error, no insert)
CALL AddNewCustomer(20,'Duplicate Test','2000-01-01',100);

SELECT CustomerID, Name FROM Customers WHERE CustomerID = 20;
SELECT * FROM AuditLog ORDER BY LogID DESC LIMIT 5;

