CREATE DATABASE `mybatis_example`;

USE `mybatis_example`;

DROP TABLE t_emp;

CREATE TABLE `t_emp`(
  emp_id INT AUTO_INCREMENT,
  emp_name VARCHAR(100),
  emp_salary DOUBLE(10,5),
  PRIMARY KEY(emp_id)
);

INSERT INTO `t_emp`(emp_name,emp_salary) VALUES("tom",200.33);
INSERT INTO `t_emp`(emp_name,emp_salary) VALUES("jerry",666.66);
INSERT INTO `t_emp`(emp_name,emp_salary) VALUES("andy",777.77);
INSERT INTO `t_emp`(emp_name,emp_salary) VALUES("jimmy",777.77);


SELECT * FROM t_emp;

SELECT emp_id AS empId, emp_name AS empName, emp_salary AS empSalary
	FROM t_emp WHERE emp_id = 1;

SELECT * FROM t_emp WHERE emp_id = 1;
	
SELECT emp_name FROM t_emp WHERE emp_id = 1;
	
DELETE FROM t_emp WHERE emp_id = 9;

SELECT emp_id AS empId, emp_name AS empName, emp_salary AS empSalary
	FROM t_emp WHERE emp_salary = 777.77;
	
SELECT emp_id AS empId, emp_name AS empName, emp_salary AS empSalary
	FROM t_emp WHERE emp_name = '张三' AND emp_salary = 114.5;