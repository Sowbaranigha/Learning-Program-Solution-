USE banksystem; 

DROP TRIGGER IF EXISTS LogTransaction;

DROP TABLE IF EXISTS AuditLog;

CREATE TABLE AuditLog (
    LogID       INT AUTO_INCREMENT PRIMARY KEY,
    ActionTime  DATETIME      DEFAULT CURRENT_TIMESTAMP,
    AccountID   INT,
    Amount      DECIMAL(10,2),
    TxnType     VARCHAR(20),
    Note        TEXT
);

DELIMITER $$

CREATE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (AccountID, Amount, TxnType, Note)
    VALUES (
        NEW.AccountID,
        NEW.Amount,
        NEW.TransactionType,
        CONCAT('TxnID ', NEW.TransactionID, ': ',
               NEW.TransactionType, ' of ', NEW.Amount)
    );
END$$

DELIMITER ;

-- Log Transaction
INSERT INTO Transactions
        (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES  (999, 1, CURDATE(), 500, 'Deposit');

SELECT * FROM AuditLog ORDER BY LogID DESC LIMIT 1;

