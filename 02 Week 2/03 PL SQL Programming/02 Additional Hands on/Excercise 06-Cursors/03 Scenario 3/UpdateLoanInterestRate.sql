DROP PROCEDURE IF EXISTS UpdateLoanInterestRates;
DELIMITER $$

/* Example policy: drop every rate by 0.5 percentage point */
CREATE PROCEDURE UpdateLoanInterestRates()
BEGIN
    DECLARE done INT DEFAULT 0;
    DECLARE v_loanID INT;

    DECLARE curLoan CURSOR FOR SELECT LoanID FROM Loans;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

    OPEN curLoan;
    LOOP_LOANS: LOOP
        FETCH curLoan INTO v_loanID;
        IF done THEN LEAVE LOOP_LOANS; END IF;

        UPDATE Loans
        SET InterestRate = InterestRate - 0.5
        WHERE LoanID = v_loanID;
    END LOOP;
    CLOSE curLoan;
END$$
DELIMITER ;

-- Calling the function Update Loan Interest Rate 
CALL UpdateLoanInterestRates();

SELECT LoanID, InterestRate FROM Loans LIMIT 5;

