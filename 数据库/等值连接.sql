#进阶6：连接查询

/*
含义：又称多表查询，当查询的字段来自于多个表时，当查询的字段来自于多个表时，就会用到连接查询
笛卡尔乘积现象：表1有m行，表2有n行，结果等于m*n行

发生原因：没有有效的连接条件
如何避免：添加有效的连接条件

分类：
     按年代分类：
     sq192
     sq199
     按功能分类：
     内连接：
	    等值连接
	    非等值连接
	    自连接
     外连接：
	    左外连接
	    右外链接
	    全外连接
     交叉连接
     
*/
#1.等值连接
/*
 多表等值连接的结果为多表的交集部分
 特点：n表连接，需要至少n-1个连接条件
 
*/
#案例1.查询女神对应的男神名
SELECT NAME,boyName
FROM beauty,boys
WHERE beauty.boyfriend_id=boys.id;

#案例2.查询员工名和对应的部门名
SELECT last_name,department_name
FROM employees,departments
WHERE employees.department_id=departments.department_id;

#2.为表起别名
/*
提高语句的简洁度
区分多个重名的字段

注意：为表起了别名，则查询字段都得是别名

*/
SELECT last_name,department_name
FROM employees e,departments
WHERE employees.department_id=departments.department_id;
#3.两个表的顺序是否可以调换
#可以

#4.可以加筛选？

#案例：查询有奖金的员工名、部门名

SELECT last_name,first_name,department_name
FROM employees e,departments d
WHERE `commission_pct` IS NOT NULL
AND e.department_id=d.department_id;

#案例2：查询城市中第二个字符为o的部门名和城市名

SELECT department_name,city
FROM departments d,locations l
WHERE d.location_id=l.location_id
AND l.city LIKE '_o%';

#5. 可以加分组？

#案例1. 查询每个城市的部门个数

SELECT COUNT(*),city
FROM locations l,departments d
WHERE l.location_id=d.location_id
GROUP BY city;

#案例2：查询有奖金的每个部门的部门名和部门的领导编号和该部门的最低工资
SELECT department_name,d.`manager_id`,MIN(salary)
FROM departments d,employees e
WHERE d.`department_id`=e.`department_id`
AND `commission_pct` IS NOT NULL
GROUP BY department_name,d.manager_id;

#案例：查询每个工种的工种名和员工的个数，并且按员工个数降序

SELECT COUNT(*),job_title
FROM employees e,jobs j
WHERE e.job_id=j.job_id
GROUP BY job_title
ORDER BY COUNT(*) DESC;

#7. 可以实现三表连接？

#案例：查询员工名、部门名和所在的城市

SELECT last_name,department_name,city
FROM employees e,departments d,locations l
WHERE d.`location_id`=l.`location_id`
AND e.`department_id`=d.`department_id`
