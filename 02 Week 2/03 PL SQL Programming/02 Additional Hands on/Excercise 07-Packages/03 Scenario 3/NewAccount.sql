DROP PROCEDURE IF EXISTS acct_open;
DELIMITER $$

CREATE PROCEDURE acc_open (
    IN p_accountID INT,
    IN p_customerID INT,
    IN p_accountType VARCHAR(20),
    IN p_initialBalance DECIMAL(10,2)
)
BEGIN
    INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
    VALUES (p_accountID, p_customerID, p_accountType, p_initialBalance, CURDATE());
END$$

DELIMITER ;

-- Account Details
SELECT * FROM Accounts ORDER BY AccountID;

-- Calling Account open
CALL acc_open(1001, 1, 'Savings', 3000);

SELECT * FROM Accounts WHERE AccountID = 1001;


