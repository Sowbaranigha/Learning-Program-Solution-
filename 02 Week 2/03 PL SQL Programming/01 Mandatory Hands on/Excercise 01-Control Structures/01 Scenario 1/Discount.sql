DELIMITER $$

CREATE PROCEDURE ApplyInterestDiscount()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_customer INT;
    DECLARE cur CURSOR FOR
        SELECT CustomerID
        FROM   Customers
        WHERE  TIMESTAMPDIFF(YEAR, DOB, CURDATE()) > 60;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN cur;
    read_loop: LOOP
        FETCH cur INTO v_customer;
        IF done THEN LEAVE read_loop; END IF;

        UPDATE Loans
        SET    InterestRate = InterestRate - 1
        WHERE  CustomerID = v_customer;
    END LOOP;
    CLOSE cur;
END$$
DELIMITER ;

--  BEFORE: all customers with any loan
SELECT c.CustomerID,
       c.Name,
       c.DOB,
       TIMESTAMPDIFF(YEAR, c.DOB, CURDATE())  AS Age,
       l.LoanID,
       l.InterestRate                         AS RateBefore
FROM   Customers  c
LEFT  JOIN Loans  l  ON l.CustomerID = c.CustomerID
ORDER BY c.CustomerID;

-- ACTION: 1 % discount for customers > 60
SET SQL_SAFE_UPDATES = 0;

UPDATE Loans l
JOIN   Customers c  ON c.CustomerID = l.CustomerID
SET    l.InterestRate = l.InterestRate * 0.99      -- 1 % relative discount
WHERE  TIMESTAMPDIFF(YEAR, c.DOB, CURDATE()) > 60;

SET SQL_SAFE_UPDATES = 1;

-- AFTER: 1% dicount for >60 age
SELECT c.CustomerID,
       c.Name,
       c.DOB,
       TIMESTAMPDIFF(YEAR, c.DOB, CURDATE())  AS Age,
       l.LoanID,
       l.InterestRate                         AS RateAfter
FROM   Customers c
JOIN   Loans     l  ON l.CustomerID = c.CustomerID
WHERE  TIMESTAMPDIFF(YEAR, c.DOB, CURDATE()) > 60
ORDER  BY c.CustomerID;

