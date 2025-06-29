DROP FUNCTION IF EXISTS CalculateMonthlyInstallment;
DELIMITER $$

CREATE FUNCTION CalculateMonthlyInstallment(
    p_amount DECIMAL(10,2),
    p_annualRate DECIMAL(5,2),
    p_years INT
)
RETURNS DECIMAL(10,2)
DETERMINISTIC
BEGIN
    DECLARE r DECIMAL(10,6);
    DECLARE n INT;
    DECLARE emi DECIMAL(10,2);

    SET r = p_annualRate / 12 / 100;
    SET n = p_years * 12;

    IF r = 0 THEN
        RETURN p_amount / n;
    END IF;

    SET emi = (p_amount * r * POW(1 + r, n)) / (POW(1 + r, n) - 1);
    RETURN emi;
END$$

DELIMITER ;

-- Monthly Installment
SELECT
    c.Name,
    l.LoanAmount,
    l.InterestRate,
    TIMESTAMPDIFF(MONTH, l.StartDate, l.EndDate) DIV 12 AS Years,
    CalculateMonthlyInstallment(
        l.LoanAmount,
        l.InterestRate,
        TIMESTAMPDIFF(MONTH, l.StartDate, l.EndDate) DIV 12
    ) AS MonthlyEMI
FROM Loans l
JOIN Customers c ON c.CustomerID = l.CustomerID;


