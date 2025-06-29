DROP PROCEDURE IF EXISTS emp_update;
DELIMITER $$
CREATE PROCEDURE emp_update(
    IN p_eid INT,
    IN p_pos VARCHAR(50),
    IN p_sal DECIMAL(10,2)
)
BEGIN
    UPDATE Employees
    SET Position = p_pos,
        Salary   = p_sal
    WHERE EmployeeID = p_eid;
END$$
DELIMITER ;

-- Update Employee Details
CALL emp_update(501, 'Software Engineer', 48000);

SELECT EmployeeID, Name, Position, Salary
FROM   Employees
WHERE  EmployeeID = 501;

