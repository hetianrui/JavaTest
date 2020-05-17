#进阶5：分组查询
/*

语法：
    select 分组函数，列（要求出现在group by的后面） 
    from 表
    where 筛选条件
    group by 分组的列表
    order by 子句
    
    注意：查询列表必须特殊，要求是分组函数和group by后出现的字段
    
    
    特点：
                    数据源           位置
                        
	分组前筛选  原始表           group by 子句的前面
	分组后筛选  分组后的结果集   group by 子句的后面
	
	（1）分组函数做条件肯定是放在having子句中
	（2）能用分组前筛选的，就优先考虑使用分组前筛选
	
	group by支持多字段，函数，表达式
	也可以添加排序
    */
#案例1.查询每个工种的最高工资
SELECT MAX(salary),job_id
FROM employees
GROUP BY job_id;

#案例2.查询每个位置上的部门个数
SELECT  COUNT(*),location_id
FROM departments
GROUP BY location_id;

#添加筛选条件
#案例1.查询邮箱中包含a字符的，每个部门的avg工资

SELECT AVG(salary),department_id
FROM employees
WHERE email LIKE '%a%'
GROUP BY department_id;

#案例2：查询每个领导手下的有奖金的员工的最高工资

SELECT MAX(salary),manager_id
FROM employees
WHERE commission_pct IS NOT NULL
GROUP BY manager_id;

#添加分组后的筛选条件

#案例1.查询哪个部门的员工个数大于2

SELECT COUNT(*) 个数,department_id 
FROM employees 
GROUP BY department_id
HAVING 个数 > 2;

#案例2.查询每个工种有奖金的员工的最高工资>12000

SELECT MAX(salary),job_id
FROM employees
WHERE commission_pct IS NOT NULL
GROUP BY job_id
HAVING MAX(salary)>12000;

#案例3.查询领导编号>102的每个领导手下的最低工资>5000领导编号是哪个，以及其最低工资

SELECT MIN(salary),manager_id
FROM employees
WHERE manager_id > 102
GROUP BY manager_id
HAVING MIN(salary) >5000;

#按表达式或函数分组

#案例：按员工姓名长度分组，查询每一组的员工个数，筛选员工个数>5的有哪些

SELECT COUNT(*),LENGTH(last_name) 长度
FROM employees
GROUP BY 长度
HAVING COUNT(1)>5;

#按多个字段进行分组

#案例：查询每个部门每个工种的员工的平均工资

SELECT AVG(salary),department_id,job_id
FROM employees
GROUP BY department_id,job_id;

#添加排序
#案例：查询每个部门每个工种的员工的平均工资
SELECT AVG(salary) \AVG,department_id,job_id
FROM employees
GROUP BY department_id,job_id
ORDER BY \AVG DESC;