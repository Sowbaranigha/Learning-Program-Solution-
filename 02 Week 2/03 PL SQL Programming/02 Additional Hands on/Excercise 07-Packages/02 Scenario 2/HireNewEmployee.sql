DROP PROCEDURE IF EXISTS emp_hire;
DELIMITER $$
CREATE PROCEDURE emp_hire(
    IN p_eid  INT,
    IN p_name VARCHAR(100),
    IN p_pos  VARCHAR(50),
    IN p_sal  DECIMAL(10,2),
    IN p_dept VARCHAR(50)
)
BEGIN
    INSERT INTO Employees(EmployeeID,Name,Position,Salary,Department,HireDate)
    VALUES(p_eid,p_name,p_pos,p_sal,p_dept,CURDATE());
END$$
DELIMITER ;

-- verifying Employee Detail
SELECT EmployeeID, Name, Position, Salary, Department
FROM   Employees
ORDER  BY EmployeeID;

-- Hiring new Employee
CALL emp_hire(501, 'Asha Kumari', 'Junior Dev', 40000, 'IT');

SELECT * FROM Employees WHERE EmployeeID = 501;


