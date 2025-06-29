USE banksystem;

DROP PROCEDURE IF EXISTS GenerateMonthlyStatements;
DELIMITER $$

CREATE PROCEDURE GenerateMonthlyStatements()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_custID INT;
    DECLARE v_name VARCHAR(100);

    DECLARE curCust CURSOR FOR
        SELECT CustomerID, Name FROM Customers;

    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN curCust;

    read_loop: LOOP
        FETCH curCust INTO v_custID, v_name;
        IF done THEN LEAVE read_loop; END IF;

        -- Print header
        SELECT CONCAT('===== Statement for ', v_name, ' (', v_custID, ') =====') AS StatementHeader;

        -- Print this customer's transactions for current month
        SELECT 
            t.TransactionDate,
            t.TransactionType,
            t.Amount,
            a.AccountType
        FROM Transactions t
        JOIN Accounts a ON a.AccountID = t.AccountID
        WHERE a.CustomerID = v_custID
          AND YEAR(t.TransactionDate) = YEAR(CURDATE())
          AND MONTH(t.TransactionDate) = MONTH(CURDATE())
        ORDER BY t.TransactionDate;

        -- Blank line for readability
        SELECT ' ' AS BlankLine;
    END LOOP;

    CLOSE curCust;
END$$

DELIMITER ;

-- Calling the function Generate Montly Statements
CALL GenerateMonthlyStatements();

-- Verifying 
SHOW PROCEDURE STATUS WHERE Db = 'banksystem';

