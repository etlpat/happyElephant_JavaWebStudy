USE mybatis_example;

DROP TABLE USER;

CREATE TABLE `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(50) NOT NULL,
  `password` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


DESC USER;

INSERT INTO USER(username, PASSWORD) 
	VALUES('张三', '111'),
	('李四', '222'),
	('王五', '333'),
	('赵六', '444'),
	('孙七', '555'),
	('周八', '666'),
	('吴九', '777');
	

INSERT INTO USER(username, PASSWORD) VALUES('张三', 123456);

DELETE FROM USER WHERE id = 1;

UPDATE USER SET username = '李四', PASSWORD = '111' WHERE id = 2;

SELECT * FROM USER WHERE id = 2;

SELECT * FROM USER;