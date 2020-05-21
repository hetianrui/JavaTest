#子查询的经典案例

#1.查询工资最低的员工信息：last_name,salary

SELECT * FROM employees
WHERE salary = (
	SELECT MIN(salary)
	FROM employees);
#2.查询平均工资最低的部门信息

SELECT AVG(salary),department_id
FROM employees e 
GROUP BY department_id
ORDER BY AVG(salary) 
LIMIT 1;

SELECT * FROM departments
WHERE department_id= (
SELECT department_id
FROM employees e 
GROUP BY department_id
ORDER BY AVG(salary) 
LIMIT 1)

#3.查询平均工资最低的部门信息和该部门的平均工资
SELECT d.*,ag FROM departments d
inner join (
	SELECT AVG(salary) ag,department_id 
	FROM employees e 
	GROUP BY department_id
	ORDER BY AVG(salary) 
	LIMIT 1
) ae
on d.department_id = ae.department_id

#4.查询平均工资最高的job信息

select avg(salary) ag,j.job_id
from employees e inner join 
jobs j
on e.job_id=j.job_id 
group by job_id
order by ag desc
limit 1

select j.* from jobs j
where job_id =(
	SELECT j.job_id
	FROM employees e INNER JOIN 
	jobs j
	ON e.job_id=j.job_id 
	GROUP BY job_id
	ORDER BY avg(salary) DESC
	LIMIT 1
	);
#5.查询平均工资高于公司平均工资的部门有哪些

#先查询每个部门的平局工资

select avg(salary) se,department_id
from employees 
group by department_id
having se>(SELECT AVG(salary) FROM employees)
;
#再查公司的平均工资
select avg(salary) from employees;
#再查高于公司平均工资的id
select department_id
from (
	SELECT AVG(salary) ae,department_id
	FROM employees 
	GROUP BY department_id
) ag
where ag.ae > (
	SELECT AVG(salary) FROM employees
	);
#再在部门表里面查上一步里面所有部门的信息	
select d.* from departments d
where d.department_id in(
	SELECT department_id
	FROM employees 
	GROUP BY department_id
	HAVING avg(salary)>(SELECT AVG(salary) FROM employees)
	);
	
#6.查询出公司中所有manager的详细信息

select manager_id
from employees

select e.* from employees e 
where e.employee_id in (
	SELECT distinct manager_id
	FROM employees );
#7.各个部门中 最高工资中 最低的那个部门的 最低工资是多少

select department_id
from employees 
group by department_id
order by MAX(salary)
limit 1
#方法一、直接在部门里查最低工资
select min(salary)
from employees
where department_id=(
	SELECT department_id
	FROM employees 
	GROUP BY department_id
	ORDER BY MAX(salary)
	LIMIT 1)
#方法二、先查到最低工资部门的员工编号，在查员工里的最低工资
select salary from employees
where employee_id =(
	SELECT employee_id
	FROM employees
	WHERE department_id=(
		SELECT department_id
		FROM employees 
		GROUP BY department_id
		ORDER BY MAX(salary)
		LIMIT 1)
)

#8.查询平均工资最高的部门的manager的详细信息：last_name,department_id,email,salary
select department_id
from employees
group by department_id
order by AVG(salary) desc
limit 1;

select manager_id
from departments
where department_id=(
	SELECT department_id
	FROM employees
	GROUP BY department_id
	ORDER BY AVG(salary) DESC
	LIMIT 1);
	
select last_name,department_id,email,salary
from employees
where employee_id =(
	SELECT manager_id
	FROM departments
	WHERE department_id=(
		SELECT department_id
		FROM employees
		GROUP BY department_id
		ORDER BY AVG(salary) DESC
		LIMIT 1)
);

