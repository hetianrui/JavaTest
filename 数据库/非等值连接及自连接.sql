#案例1.查询员工的工资和工资级别

SELECT salary,grade_level
FROM employees,job_grades j
WHERE salary BETWEEN j.`lowest_sal` AND j.`highest_sal`
ORDER BY salary DESC;

# 自连接
#案例：查询员工名和它的上级名

SELECT e.last_name,e.employee_id,m.last_name,m.employee_id
FROM employees e, employees m
WHERE e.manager_id=m.employee_id