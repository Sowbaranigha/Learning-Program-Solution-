DROP TRIGGER IF EXISTS CheckTransactionRules;
DELIMITER $$

CREATE TRIGGER CheckTransactionRules
BEFORE INSERT ON Transactions
FOR EACH ROW
BEGIN
    DECLARE v_balance DECIMAL(10,2);

    /* ---- Rule 0: amount must be positive ---- */
    IF NEW.Amount <= 0 THEN
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Amount must be positive';
    END IF;

    /* ---- Rule 1: Deposit (already passed amount check) ---- */
    IF NEW.TransactionType = 'Deposit' THEN
        -- do nothing; deposit is allowed
        SET v_balance = v_balance; 

    /* ---- Rule 2: Withdrawal must not exceed balance ---- */
    ELSEIF NEW.TransactionType = 'Withdrawal' THEN
        SELECT Balance
          INTO v_balance
          FROM Accounts
         WHERE AccountID = NEW.AccountID
         FOR UPDATE;                    -- lock row during check

        IF v_balance < NEW.Amount THEN
            SIGNAL SQLSTATE '45000'
                SET MESSAGE_TEXT = 'Insufficient balance for withdrawal';
        END IF;

    /* ---- Unknown transaction type ---- */
    ELSE
        SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Unknown transaction type';
    END IF;
END$$
DELIMITER ;

-- Find the current balance of an account
SELECT AccountID, Balance FROM Accounts WHERE AccountID = 1;

-- Valid deposit (should succeed)
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2001, 1, CURDATE(), 100, 'Deposit');

-- Valid withdrawal ≤ balance (should succeed)
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2002, 1, CURDATE(), 300, 'Withdrawal');

-- Overalldraw withdrawal (should fail)
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2003, 1, CURDATE(), 999999, 'Withdrawal');

-- Negative deposit (should fail)
INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (2004, 1, CURDATE(), -50, 'Deposit');

-- Confirm what actually got inserted
SELECT TransactionID, Amount, TransactionType
FROM   Transactions
WHERE  TransactionID IN (2001, 2002, 2003, 2004);



