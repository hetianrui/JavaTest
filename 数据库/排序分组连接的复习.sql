#复习前一天的内容

#查询员工表的employee_id,job_id,last_name,按department_id降序，salary升序
SELECT employee_id,job_id,last_name,salary,department_id
FROM employees
ORDER BY department_id DESC,salary ASC;

#查询员工表的job_id中包含a和e的，并且a在e的前面

SELECT job_id
FROM employees
WHERE job_id LIKE '%a%e%';

#显示当前日期，以及去前后空格，截取子字符串的函数

SELECT NOW();
SELECT TRIM('  dfsdfsd   46465465');
SELECT SUBSTR('fsdfsdf',5,1);
