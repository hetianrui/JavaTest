#子查询练习

#1.查询和zlotkey相同部门的员工姓名和工资

#先查zlotkey的部门id
SELECT department_id
FROM employees
WHERE last_name='zlotkey';
#基础上在查姓名，工资
SELECT last_name,salary,e.department_id
FROM employees e 
WHERE e.department_id=(
	SELECT department_id
	FROM employees
	WHERE last_name='zlotkey'
	);
	
#2.查询工资比公司平均水平高的员工的员工号，姓名和工资

#先查公司的平均水平工资的员工

SELECT AVG(salary)
FROM employees
#基础上再查
SELECT employee_id,last_name,salary
FROM employees
WHERE salary > (
	SELECT AVG(salary)
	FROM employees
)
ORDER BY salary DESC;

#3.查询各部门工资比本部门平均工资高的员工的员工号，姓名和工资

#先查每个部门的平均工资

SELECT AVG(salary),department_id
FROM employees
GROUP BY department_id

#基础上再查,把上一步查出的表和员工表连接起来再筛选

SELECT employee_id,last_name,salary
FROM employees e INNER JOIN (
	SELECT AVG(salary) a,department_id
	FROM employees
	GROUP BY department_id
	) s
	ON e.department_id = s.department_id
	WHERE salary > s.a ;
	
#4.查询和姓名中包含字母u的员工在相同部门的员工的员工号和姓名
#先查包含字母u的员工的部门编号
SELECT department_id
FROM employees
WHERE last_name LIKE '%u%'
#再查部门号在上一步里面的员工

SELECT employee_id,e.last_name,department_id
FROM employees e
WHERE e.department_id IN(
	SELECT DISTINCT department_id
	FROM employees
	WHERE last_name LIKE '%u%')
	
#5.查询在部门的location_id为1700的部门工作的员工的员工号

#查询location_id为1700的部门
SELECT department_id
FROM departments
WHERE location_id = 1700

#在上一步的基础上再查部门在上一步里面的员工的员工号

SELECT employee_id
FROM employees
WHERE department_id IN(
	SELECT department_id
	FROM departments
	WHERE location_id = 1700
);

#6.查询管理者是king的员工名和工资

SELECT e.employee_id,e.last_name,e.salary,e.manager_id,a.employee_id,a.last_name
FROM employees e INNER JOIN employees a 
ON e.manager_id=a.employee_id
AND a.last_name='k_ing'
#7. 查询工资最高的员工的姓名，要求first_name和last_name显示为一列，列名为 姓,名

SELECT MAX(salary)
FROM employees

SELECT CONCAT(first_name,last_name) '姓，名'
FROM employees
WHERE salary = (
	SELECT MAX(salary)
	FROM employees
)