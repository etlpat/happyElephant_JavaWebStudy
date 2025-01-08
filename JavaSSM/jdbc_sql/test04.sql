USE `mybatis_example`;

SHOW TABLES;

DROP TABLE students;

DESC students;

CREATE TABLE students (
	id INT(11) NOT NULL AUTO_INCREMENT,  
	NAME VARCHAR(20) NOT NULL,  
	age INT(11) NOT NULL,  
	gender VARCHAR(255) DEFAULT NULL,  
	NUMBER VARCHAR(20) DEFAULT NULL, 
	address VARCHAR(20) DEFAULT NULL, 
	STATUS INT(11) NOT NULL DEFAULT  1,  
	PRIMARY KEY (id)
);

INSERT INTO students(NAME,age,gender,NUMBER,address,STATUS)
	VALUES('张三',18,'男','1234567','山西',1),
	('李四',19,'女','3334444','北京',2),
	('王五',20,'男','0351000','上海',1),
	('赵六',22,'女','0351222','山西',1),
	('孙七',19,'女','7777777','深圳',2),
	('张三风',28,'男','1234321','山西',3),
	('陈哥',30,'男','0351444','陕西',2),
	('三明治',15,'女','1515151','山西',1),
	('鲁树人',88,'男','8888888','浙江',1),
	('顶侦',22,'男','7654321','麻麻',2);


SELECT * FROM students;

SELECT * FROM students WHERE NAME LIKE '%三%';
	
SELECT * FROM students WHERE NAME='张三' AND address='山西';

DELETE FROM students WHERE id = 1;

UPDATE students 
	SET NAME='李四',age=22,gender='女',NUMBER='114514',address='山西大同',STATUS=555
	WHERE id = 2;