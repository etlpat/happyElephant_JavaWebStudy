USE mybatis_example;
SHOW TABLES;


 CREATE TABLE `t_article` (
 `id` INT(20) NOT NULL AUTO_INCREMENT COMMENT '文章 id',
`title` VARCHAR(200) DEFAULT NULL COMMENT '文章标题',
 `content` LONGTEXT COMMENT '文章内容',
 PRIMARY KEY (`id`)
 ) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 
 
INSERT INTO `t_article` VALUES 
	('1', 'Spring Boot 基础入门', '从入门到精通讲解...'),
	('2', 'Spring Cloud 基础入门', '从入门到精通讲解...'); 
 
 
  CREATE TABLE `t_comment` (
 `id` INT(20) NOT NULL AUTO_INCREMENT COMMENT '评论 id',
 `content` LONGTEXT COMMENT '评论内容',
 `author` VARCHAR(200) DEFAULT NULL COMMENT '评论作者',
 `a_id` INT(20) DEFAULT NULL COMMENT '关联的文章id',
 PRIMARY KEY (`id`)
 ) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 
 
 INSERT INTO `t_comment` VALUES 
	('1', '很详细', 'jimmy', '1'),
	('2', '赞一个', 'etlpat', '1'),
	('3', '很详细', 'bob', '1'),
	('4', '很好，非常详细', 'alice', '1'),
	('5', '很不错', 'jack', '2');
	
	
	
SELECT * FROM t_article;
SELECT * FROM t_comment;