CREATE DATABASE ry;
USE ry;

DROP TABLE t_article;
DROP TABLE t_comment;

#（1）创建t_article
 CREATE TABLE `t_article` (
 `id` INT(20) NOT NULL AUTO_INCREMENT COMMENT '文章 id',
 `title` VARCHAR(200) DEFAULT NULL COMMENT '文章标题',
 `content` LONGTEXT COMMENT '文章内容',
 PRIMARY KEY (`id`)
 ) ENGINE=INNODB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
 
#（2）创建t_comment
 CREATE TABLE `t_comment` (
 `id` INT(20) NOT NULL AUTO_INCREMENT COMMENT '评论 id',
 `content` LONGTEXT COMMENT '评论内容',
 `author` VARCHAR(200) DEFAULT NULL COMMENT '评论作者',
 `a_id` INT(20) DEFAULT NULL COMMENT '关联的文章id',
 PRIMARY KEY (`id`)
 ) ENGINE=INNODB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
 
#（3）为t_article添加数据
INSERT INTO `t_article` VALUES ('1', 'Spring Boot 基础入门', '从入门到
精通讲解...');
INSERT INTO `t_article` VALUES ('2', 'Spring Cloud 基础入门', '从入门到
精通讲解...');
 );
 
#（4）为t_comment添加数据
INSERT INTO `t_comment` VALUES ('1', '很全、很详细', '狂奔的蜗牛', '1');
INSERT INTO `t_comment` VALUES ('2', '赞一个', 'tom', '1');
INSERT INTO `t_comment` VALUES ('3', '很详细', 'kitty', '1');
INSERT INTO `t_comment` VALUES ('4', '很好，非常详细', '张三', '1');
INSERT INTO `t_comment` VALUES ('5', '很不错', '张杨', '2');


SELECT * FROM t_article;
SELECT * FROM t_comment;