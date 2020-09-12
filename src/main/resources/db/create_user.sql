create database expense_tracker; -- Creates the new database
create user 'expensify'@'%' identified by 'expensify'; -- Creates the user
grant all on expense_tracker.* to 'expensify'@'%'; -- Gives all privileges to the new user on the newly created database