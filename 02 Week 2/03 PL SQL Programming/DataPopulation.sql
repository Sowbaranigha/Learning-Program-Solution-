INSERT INTO Customers (CustomerID, Name, DOB, Balance, LastModified)
VALUES (1, 'John Doe', '1935-05-15', 1000, CURDATE()),
       (2, 'Jane Smith', '1990-07-20', 1500, CURDATE()),
       (3, 'Suresh Kumar', '1958-02-11', 18000,  CURDATE()),
       (4, 'Lakshmi Iyer', '1998-09-05',  4200,  CURDATE()),
       (5, 'Rahul Mehta', '1979-04-23', 10550,  CURDATE()),
       (6, 'Meera Rao', '1940-12-30',   950,  CURDATE());
       
INSERT INTO Accounts (AccountID, CustomerID, AccountType, Balance, LastModified)
VALUES (1, 1, 'Savings', 50000, CURDATE()),
       (2, 2, 'Checking', 1500, CURDATE()),
       (3, 3, 'Savings', 18000, CURDATE()),
       (4, 4, 'Checking', 4200, CURDATE()),
       (5, 5, 'Savings', 10550, CURDATE()),
       (6, 6, 'FixedDeposit', 950, CURDATE());

INSERT INTO Transactions (TransactionID, AccountID, TransactionDate, Amount, TransactionType)
VALUES (1, 1, CURDATE(), 200, 'Deposit'),
       (2, 2, CURDATE(), 300, 'Withdrawal'),
       (3, 3, CURDATE(), 5000, 'Deposit'),
       (4, 4, CURDATE(), 800, 'Deposit'),
       (5, 5, CURDATE(), 2000, 'Deposit'),
       (6, 4, CURDATE(), 300, 'Withdrawal'),
       (7, 6, CURDATE(), 150, 'Withdrawal'),
       (8, 3, CURDATE(), 2500, 'Withdrawal');

INSERT INTO Loans (LoanID, CustomerID, LoanAmount, InterestRate, StartDate, EndDate)
VALUES (1, 1, 15000, 5, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 60 MONTH)),
(2, 6,  3000, 6.5, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 12 MONTH)),
(3, 5, 12000, 7.0, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 25 MONTH)),
(4, 3, 50000, 5.5, CURDATE(), DATE_ADD(CURDATE(), INTERVAL 45 MONTH));

INSERT INTO Employees (EmployeeID, Name, Position, Salary, Department, HireDate)
VALUES (1, 'Alice Johnson', 'Manager', 70000, 'HR', '2015-06-15'),
       (2, 'Bob Brown', 'Developer', 60000, 'IT', '2017-03-20'),
       (3, 'Kavita Singh', 'Analyst', 55000, 'Finance', '2018-11-12'),
       (4, 'Rohit Sharma', 'Tester', 48000, 'IT', '2020-04-01'),
       (5, 'Devika Nair', 'HR Exec', 52000, 'HR', '2022-01-18');

-- verify the table
Select *from Customers;
Select * from Accounts;
Select *from Transactions;
Select *from Loans;
Select *from Employees;