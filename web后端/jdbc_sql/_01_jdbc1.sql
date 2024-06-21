-- 创建jdbc库
CREATE DATABASE jdbc;

USE jdbc;

CREATE TABLE students(
	id INT PRIMARY KEY,
	`name` VARCHAR(32),
	sex VARCHAR(8),
	age INT,
	email VARCHAR(64)
);

SHOW TABLES;
DESC students;

INSERT INTO students VALUES
	(1, '张三', '男', 18, 'zhangsan@qq.com'),
	(2, '李四', '女', 16, 'lisi@163.com'),
	(3, '王五', '男', 12, 'wangwu@126.com');
	
SELECT * FROM students;


-- =====================================================


CREATE TABLE users(
	`id` INT PRIMARY KEY AUTO_INCREMENT,
	`username` VARCHAR(16),
	`email` VARCHAR(32),
	`password` VARCHAR(32),
	`lastlogintime` DATETIME
);

DROP TABLE users;

DESC users;
SELECT * FROM users;


-- =====================================================


CREATE TABLE students1(
	id INT PRIMARY KEY AUTO_INCREMENT,
	`name` VARCHAR(32) NOT NULL,
	email VARCHAR(32) NOT NULL
);

DROP TABLE students1;

INSERT INTO students1 VALUES(NULL, '孙祥哈', '8765@123.com');

DESC students1;

SELECT * FROM students1;


-- =====================================================


CREATE TABLE users1(
	`username` VARCHAR(32) PRIMARY KEY,
	`password` VARCHAR(32)
);

DROP TABLE users;

DESC users;
SELECT * FROM users;

