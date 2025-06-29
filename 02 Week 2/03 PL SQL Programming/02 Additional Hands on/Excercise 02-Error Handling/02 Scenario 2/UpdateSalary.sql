DROP PROCEDURE IF EXISTS UpdateSalary;
DELIMITER $$

CREATE PROCEDURE UpdateSalary
( IN p_empID    INT,
  IN p_percent  DECIMAL(5,2) )         -- e.g. 7.5 = +7.5%
BEGIN
    DECLARE EXIT HANDLER FOR SQLEXCEPTION
    BEGIN
        ROLLBACK;
        INSERT INTO AuditLog (Severity, Location, Message)
        VALUES ('ERROR','UpdateSalary',
                CONCAT('FAILED salary update for EmpID ', p_empID,
                       ' – error during update'));
    END;

    START TRANSACTION;

    UPDATE Employees
       SET Salary = Salary * (1 + p_percent / 100)
     WHERE EmployeeID = p_empID;

    IF ROW_COUNT() = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Employee not found';
    END IF;

    COMMIT;

    INSERT INTO AuditLog (Severity, Location, Message)
    VALUES ('INFO','UpdateSalary',
            CONCAT('Salary +', p_percent, '% for EmpID ', p_empID));
END$$
DELIMITER ;

-- Test with valid employee
CALL UpdateSalary(1, 10);

-- Test with invalid employee (e.g., doesn't exist)
CALL UpdateSalary(999, 5);

-- View updated employee
SELECT EmployeeID, Name, Salary FROM Employees WHERE EmployeeID = 1;

-- View logs
SELECT * FROM AuditLog ORDER BY LogID DESC;

