DROP PROCEDURE IF EXISTS acct_close;
DELIMITER $$

CREATE PROCEDURE acc_close (
    IN p_accountID INT
)
BEGIN
    DELETE FROM Accounts
    WHERE AccountID = p_accountID;
END$$

DELIMITER ;

-- Closing an Account
CALL acc_close(1001);

SELECT * FROM Accounts WHERE AccountID = 1001;


