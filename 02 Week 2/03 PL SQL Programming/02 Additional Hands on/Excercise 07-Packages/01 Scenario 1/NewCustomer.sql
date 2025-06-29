DROP PROCEDURE IF EXISTS cust_add;
DELIMITER $$
CREATE PROCEDURE cust_add(
    IN p_id   INT,
    IN p_name VARCHAR(100),
    IN p_dob  DATE,
    IN p_bal  DECIMAL(10,2)
)
BEGIN
    INSERT INTO Customers(CustomerID,Name,DOB,Balance,LastModified)
    VALUES(p_id,p_name,p_dob,p_bal,CURDATE());
END$$
DELIMITER ;

-- new customer calling
CALL cust_add(101, 'Kumar Raj', '1982-03-10', 7200);

-- check customer added
SELECT * FROM Customers WHERE CustomerID = 101;
