
CREATE TABLE test.account
(
    accountId varchar(40) PRIMARY KEY NOT NULL,
    accountName varchar(30),
    sum decimal(10,2) DEFAULT '0.00'
);
INSERT INTO test.account (accountId, accountName, sum) VALUES ('1', '张三', 200.13);
INSERT INTO test.account (accountId, accountName, sum) VALUES ('2', '李四', 500.00);