CREATE DATABASE studb;

USE studb;


CREATE TABLE students (
  id INT PRIMARY KEY,
  NAME VARCHAR(50) NOT NULL,
  gender VARCHAR(10) NOT NULL,
  age INT,
  class VARCHAR(50)
);

INSERT INTO students (id, NAME, gender, age, class)
VALUES
  (1, '张三', '男', 20, '高中一班'),
  (2, '李四', '男', 19, '高中二班'),
  (3, '王五', '女', 18, '高中一班'),
  (4, '赵六', '女', 20, '高中三班'),
  (5, '刘七', '男', 19, '高中二班'),
  (6, '陈八', '女', 18, '高中一班'),
  (7, '杨九', '男', 20, '高中三班'),
  (8, '吴十', '男', 19, '高中二班');



SELECT * FROM students;
SELECT * FROM students WHERE id = 1;
INSERT INTO students (id, NAME, gender, age, class) VALUES(10,'驴蛋子','男',32,'二年三班');
DELETE FROM students WHERE id = 11;
SELECT id,NAME,gender,age,class AS classes FROM students;