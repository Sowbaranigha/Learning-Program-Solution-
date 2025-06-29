DROP PROCEDURE IF EXISTS cust_update;
DELIMITER $$
CREATE PROCEDURE cust_update(
    IN p_id   INT,
    IN p_name VARCHAR(100),
    IN p_dob  DATE
)
BEGIN
    UPDATE Customers
    SET Name = p_name,
        DOB  = p_dob,
        LastModified = CURDATE()
    WHERE CustomerID = p_id;
END$$
DELIMITER ;

-- Update the Customer detail
CALL cust_update(101, 'Kumar R', '1982-05-15');

-- verifying
SELECT * FROM Customers WHERE CustomerID = 101;

