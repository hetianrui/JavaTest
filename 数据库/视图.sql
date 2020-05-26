#视图

/*
含义：虚拟表，和普通表一样使用
MySQL 5.1版本出现的新特性，是通过表动态生成的数据

比如：
*/

#一、创建视图
/*
create view 视图名
as
查询语句


*/
USE myemployees;

#1. 查询姓名中包含a字符的员工名、部门名和工种信息

CREATE VIEW m1
AS
SELECT last_name,department_name,job_title
FROM employees e INNER JOIN departments d ON e.department_id=d.department_id
INNER JOIN jobs j ON e.job_id=j.job_id;

SELECT * FROM m1 WHERE last_name LIKE '%a%';

#2. 查询各部门的平均工资级别

CREATE VIEW my2
AS
SELECT AVG(salary) ad
FROM employees
GROUP BY department_id;

SELECT * FROM my2;

SELECT my2.ad,j.`grade_level`
FROM my2  JOIN job_grades j
ON my2.ad BETWEEN j.`lowest_sal` AND j.`highest_sal`;

#3. 查询平均工资最低的部门信息
CREATE VIEW my6
AS
SELECT * FROM my3 ORDER BY my3.ad LIMIT 1;

SELECT d.* FROM departments d JOIN my6
WHERE d.department_id=my6.department_id;

#二、视图的修改
/*
方式一、
create or replace view 视图名
as 
查询语句;

有则修改，没有则创建

方式二、
alter view 视图名
查询语句;

*/

#三、视图的删除
DROP VIEW m2,my4,my5;

#四、视图的查看

DESC my2;
SHOW CREATE VIEW my2;

CREATE VIEW lo
AS
SELECT `grade_level` FROM `job_grades`;
INSERT INTO lo VALUES('P');
DELETE FROM `job_grades` WHERE `grade_level`='P';


