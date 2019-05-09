CREATE TABLE test.account
(
    accountId varchar(40) PRIMARY KEY NOT NULL,
    accountName varchar(30),
    sum decimal(10,2) DEFAULT '0.00'
);
INSERT INTO test.account (accountId, accountName, sum) VALUES ('1', '张三', 10.00);
INSERT INTO test.account (accountId, accountName, sum) VALUES ('2', '李四', 180.00);
CREATE TABLE test.product
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    productName varchar(200) NOT NULL,
    stock int(11) DEFAULT '0' NOT NULL COMMENT '库存',
    price decimal(10,2) DEFAULT '0.00' NOT NULL,
    version int(11) DEFAULT '0' NOT NULL COMMENT '版本',
    note varchar(200) COMMENT '备注'
);
INSERT INTO test.product (id, productName, stock, price, version, note) VALUES (1, '默认产品1', 100, 9.99, 1, '无');
CREATE TABLE test.purchaserecord
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    userId int(11) NOT NULL,
    productId int(11) NOT NULL,
    price decimal(10,2) NOT NULL COMMENT '单件价格',
    quantity int(11) DEFAULT '0' NOT NULL,
    sum decimal(10,2) DEFAULT '0.00' NOT NULL COMMENT '总价',
    purchaseDate datetime DEFAULT CURRENT_TIMESTAMP NOT NULL,
    note varchar(200)
);
INSERT INTO test.purchaserecord (id, userId, productId, price, quantity, sum, purchaseDate, note) VALUES (1, 1001, 1, 1.00, 10, 99.90, '2019-04-26 10:10:08', null);
CREATE TABLE test.role
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    role varchar(30) NOT NULL
);
CREATE TABLE test.user
(
    id int(11) PRIMARY KEY NOT NULL AUTO_INCREMENT,
    username varchar(50) NOT NULL,
    password varchar(50) NOT NULL,
    role varchar(20)
);
INSERT INTO test.user (id, username, password, role) VALUES (1, 'zhangsan', '1234', 'user');
INSERT INTO test.user (id, username, password, role) VALUES (2, 'lisi', '1234', 'admin');