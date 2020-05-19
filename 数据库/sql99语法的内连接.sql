/*
二、sql99语法

连接语法：
	select 查询列表
	from 表1 别名 【连接类型】
	join 表2 别名 on 连接条件
	
内连接 inner
外连接 outer
       左外：left outer
       右外：right outer
       全外：full outer
交叉连接：cross 
...
*/

#一、内连接
#(1) 等值连接
/*
select 查询列表
from 表1 别名 
inner join 表2 别名 on 连接条件

*/

#案例1、查询员工名、部门名

SELECT last_name,department_name
FROM employees e
INNER JOIN departments d
ON e.department_id=d.department_id;

#案例2、查询名字中包含e的员工名和工种名（添加筛选）

SELECT last_name,job_title
FROM employees e
INNER JOIN jobs j
ON e.job_id=j.job_id
WHERE last_name LIKE '%e%';

#案例3、查询部门个数>3的城市名和部门个数（添加分组+筛选）

SELECT COUNT(*),city
FROM locations l
INNER JOIN departments d
ON l.location_id=d.location_id
GROUP BY city
HAVING COUNT(*) > 3;

#案例4、查询哪个部门的员工个数>3的部门名和员工个数，并按个数排序（添加排序）

SELECT COUNT(*),department_name
FROM departments d
INNER JOIN employees e
ON d.`department_id`=e.`department_id`
GROUP BY department_name
HAVING COUNT(*) > 3;

#案例5、查询员工名、部门名、工种名、并按部门名降序
SELECT last_name,department_name,job_title
FROM employees e
INNER JOIN departments d ON e.`department_id`=d.`department_id`
INNER JOIN jobs j ON e.`job_id`=j.`job_id`
ORDER BY `department_name` DESC;

#(2)非等值连接

#查询员工的工资级别

SELECT grade_level,salary
FROM `job_grades` j
JOIN  `employees` e
ON salary BETWEEN `lowest_sal` AND `highest_sal`
ORDER BY salary DESC;

#(3) 自连接

#查询员工名及上级领导名

SELECT e.last_name,e.`manager_id`,m.`last_name`,m.`employee_id`
FROM employees e INNER JOIN employees m
ON e.`manager_id`=m.`employee_id`