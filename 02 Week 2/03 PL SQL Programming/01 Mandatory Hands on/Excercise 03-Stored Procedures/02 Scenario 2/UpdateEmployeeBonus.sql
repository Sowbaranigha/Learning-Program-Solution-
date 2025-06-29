
DROP PROCEDURE IF EXISTS UpdateEmployeeBonus;
DELIMITER $$

CREATE PROCEDURE UpdateEmployeeBonus(
    IN p_dept     VARCHAR(50),
    IN p_bonusPct DECIMAL(5,2)  -- e.g., 10 for 10%
)
BEGIN
    UPDATE Employees
    SET Salary = Salary * (1 + p_bonusPct / 100)
    WHERE Department = p_dept;
END$$

DELIMITER ;

-- Give a 10% bonus to all employees in the HR department
CALL UpdateEmployeeBonus('HR', 10);

-- Check updated salaries in the HR department
SELECT EmployeeID, Name, Department, Salary
FROM Employees
WHERE Department = 'HR';
