DROP FUNCTION IF EXISTS emp_annual_salary;
DELIMITER $$
CREATE FUNCTION emp_annual_salary(p_eid INT)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE v_monthly DECIMAL(10,2);
    SELECT Salary INTO v_monthly FROM Employees WHERE EmployeeID = p_eid;
    RETURN v_monthly * 12;
END$$
DELIMITER ;

-- Annual Salary of Employee
SELECT emp_annual_salary(501) AS AnnualPay;
