-- 创建数据库
CREATE DATABASE big_event;

-- 使用数据库
USE big_event;

SHOW TABLES;


DROP TABLE USER;
DROP TABLE category;
DROP TABLE article;


-- 用户表
CREATE TABLE USER (
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
	username VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
	PASSWORD VARCHAR(32) COMMENT '密码',
	nickname VARCHAR(10) DEFAULT '' COMMENT '昵称',
	email VARCHAR(128) DEFAULT '' COMMENT '邮箱',
	user_pic VARCHAR(128) DEFAULT '' COMMENT '头像',
	create_time DATETIME NOT NULL COMMENT '创建时间',
	update_time DATETIME NOT NULL COMMENT '修改时间'
) COMMENT '用户表';

DESC USER;


-- 分类表
CREATE TABLE category(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
	category_name VARCHAR(32) NOT NULL COMMENT '分类名称',
	category_alias VARCHAR(32) NOT NULL COMMENT '分类别名',
	create_user INT UNSIGNED NOT NULL COMMENT '创建人ID',
	create_time DATETIME NOT NULL COMMENT '创建时间',
	update_time DATETIME NOT NULL COMMENT '修改时间',
	CONSTRAINT fk_category_user FOREIGN KEY (create_user) REFERENCES USER(id) -- 外键
);

DESC category;


-- 文章表
CREATE TABLE article(
	id INT UNSIGNED PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
	title VARCHAR(30) NOT NULL COMMENT '文章标题',
	content VARCHAR(10000) NOT NULL COMMENT '文章内容',
	cover_img VARCHAR(128) NOT NULL COMMENT '文章封面',
	state VARCHAR(3) DEFAULT '草稿' COMMENT '文章状态:只能是[已发布]或者[草稿]',
	category_id INT UNSIGNED COMMENT '文章分类ID',
	create_user INT UNSIGNED NOT NULL COMMENT '创建人ID',
	create_time DATETIME NOT NULL COMMENT '创建时间',
	update_time DATETIME NOT NULL COMMENT '修改时间',
	CONSTRAINT fk_article_category FOREIGN KEY (category_id) REFERENCES category(id),
	CONSTRAINT fk_article_user FOREIGN KEY (create_user) REFERENCES USER(id) 
);

DESC article;


-- ==========================================================================================================


SELECT * FROM USER;
SELECT * FROM category;
SELECT * FROM article;
