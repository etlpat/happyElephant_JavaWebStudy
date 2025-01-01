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

SELECT * FROM students;


INSERT INTO students(NAME,age,gender,NUMBER,address,STATUS)
	VALUES('张三',18,'男','03512333','北京周口店龙骨山',233);

DELETE FROM students WHERE id = 1;

UPDATE students 
	SET NAME='李四',age=22,gender='女',NUMBER='114514',address='山西大同',STATUS=555
	WHERE id = 2;