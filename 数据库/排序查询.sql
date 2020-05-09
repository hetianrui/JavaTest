#进阶3：排序查询
/*
语法：
select 查询列表
form   表
order by 排序列表 【asc|desc】

asc 表示升序，desc表示降序
不写默认升序
*/
# 案例：查询员工表中薪水降序的员工信息
SELECT
	*
FROM
	EMPLOYEES
ORDER BY salary DESC;
#案例2：查询部门编号>=的员工信息，按入职时间先后
SELECT 
	*
FROM
	employees
WHERE
	department_id>=90
ORDER BY
	hiredate ASC;
#案例3：按年薪的高低显示员工的信息和年薪【按表达式排序】
SELECT
	*,
	salary*12*(1+IFNULL(commission_pct,0)) AS 年薪
FROM
	employees
ORDER BY
	salary*12*(1+IFNULL(commission_pct,0));
#案例4：按年薪的高低显示员工的信息和年薪【按别名排序】
SELECT
	*,
	salary*12*(1+IFNULL(commission_pct,0)) AS 年薪
FROM
	employees
ORDER BY
	年薪 ASC;
#案例5：按姓名的长度显示员工的姓名和工资【按函数排序】
#长度函数 length(查询字段)
SELECT
	LENGTH(last_name) 姓名长度,
	last_name,
	salary
FROM
	employees
ORDER BY
	LENGTH(last_name);
#案例6：查询员工信息，要求先按工资升序，再按员工编号降序【按多个字段排序】
#员工编号为次要排序关键字，就是工资一样的时候，再按员工编号降序
SELECT
	*
FROM
	employees
ORDER BY
	salary ASC,employee_id DESC;
/*
总结：
1. asc代表的是升序，desc代表的是降序，不写默认升序

2. order by子句中可以支持单个字段、多个字段、表达式、函数、别名

3. order by子句一般是放在查询语句的最后面，limit子句除外

*/