USE mybatis_example;

DROP TABLE USER;

CREATE TABLE `user` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
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
	

INSERT INTO USER(username, PASSWORD) 
	VALUES('alice', '35168'),
	('bob', '6843'),
	('car', '684'),
	('keke', '491'),
	('elephant', '268'),
	('lili', '6961'),
	('otto', '59626');
	

INSERT INTO USER(username, PASSWORD) VALUES('张三', 123456);

DELETE FROM USER WHERE id = 1;

UPDATE USER SET username = '李四', PASSWORD = '111' WHERE id = 2;

SELECT * FROM USER WHERE id = 2;

SELECT * FROM USER;


# wrapper测试案例

select * from user where username like '%jim%' and password is not null;

SELECT * FROM USER order by username asc,password desc;

delete from user where username is null;

update user set password='12345678' where username like '%jim%' AND PASSWORD LIKE '%8%' OR PASSWORD IS NULL;

select id,username from user;

update user set password = '111' where username = '张三';