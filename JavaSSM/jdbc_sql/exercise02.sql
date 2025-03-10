USE mybatis_example;

DROP TABLE `t_emp`;

CREATE TABLE `t_emp`(
  emp_id INT AUTO_INCREMENT,
  emp_name CHAR(100),
  emp_salary DOUBLE(10,5),
  PRIMARY KEY(emp_id)
);

DESC `t_emp`;

INSERT INTO `t_emp`(emp_name,emp_salary) VALUES("tom",200.33);
INSERT INTO `t_emp`(emp_name,emp_salary) VALUES("jerry",666.66);
INSERT INTO `t_emp`(emp_name,emp_salary) VALUES("andy",777.77);

DELETE FROM t_emp WHERE emp_id = 1;

UPDATE t_emp SET emp_name='张三',emp_salary=321 WHERE emp_id = 2;

SELECT * FROM t_emp WHERE emp_id = 2;

SELECT * FROM t_emp;