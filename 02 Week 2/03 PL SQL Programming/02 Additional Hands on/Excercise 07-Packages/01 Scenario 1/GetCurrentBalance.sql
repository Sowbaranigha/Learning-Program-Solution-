DROP FUNCTION IF EXISTS cust_balance;
DELIMITER $$
CREATE FUNCTION cust_balance(p_id INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE v_bal DECIMAL(10,2);
    SELECT Balance INTO v_bal FROM Customers WHERE CustomerID = p_id;
    RETURN v_bal;
END$$
DELIMITER ;

-- get Customer Current balance
SELECT cust_balance(101) AS Balance;
