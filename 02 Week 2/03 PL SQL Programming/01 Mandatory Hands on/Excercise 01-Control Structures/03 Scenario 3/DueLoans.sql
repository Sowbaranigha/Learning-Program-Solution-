DELIMITER $$
CREATE PROCEDURE RemindDueLoans()
BEGIN
    -- We’ll just SELECT messages; Workbench shows them in the result grid
    SELECT CONCAT('Reminder: Loan ', LoanID, ' for ',
                  c.Name, ' is due on ', DATE_FORMAT(l.EndDate,'%Y-%m-%d'))
           AS ReminderMessage
    FROM   Loans l
    JOIN   Customers c  ON c.CustomerID = l.CustomerID
    WHERE  l.EndDate BETWEEN CURDATE() AND DATE_ADD(CURDATE(), INTERVAL 30 DAY);
END$$
DELIMITER ;

-- Loans whose end date is within the next 30 calendar days
SELECT l.LoanID,
       c.Name,
       l.EndDate
FROM   Loans      l
JOIN   Customers  c ON c.CustomerID = l.CustomerID
WHERE  l.EndDate BETWEEN CURDATE()
                    AND DATE_ADD(CURDATE(), INTERVAL 30 DAY)
ORDER BY l.EndDate;
