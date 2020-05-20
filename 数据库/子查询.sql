# 进阶7：子查询

/*
含义：出现在其他语句中的select语句，称为子查询或内查询
      外部的查询语句，称为主查询或外查询
分类：
按子查询出现的位置：
      select后面：
           仅仅支持量子查询
      from后面：
           支持表子查询
      where或having后面：
           标量子查询
           行
           列
           
      exists后面（相关子查询）
按结果集的行列数不同：
      标量子查询（结果集只有一行一列）
      列子查询（结果集只有一列多行）
      行子查询（结果集有一行多列）
      表子查询（结果集一般为多行多列）      
*/

#一、where或having后面
/*
1.标量子查询（单行子查询）
2.列子查询（多行子查询）
3.行子查询（多行多列）

特点：
（1）子查询放在小括号内
（2）子查询一般放在条件的右侧
（3）标量子查询，一般搭配着单行操作符使用
> < >= <= = <>

列子查询，一般搭配多行操作符使用
in,any/some、all

*/
#1、标量子查询

#案例1. 谁的工资比Abel的高？

#（1）先查询Abel的工资

select salary
from employees 
where last_name='Abel';

#(2) 在一的基础上查询高于1的工资

select last_name,salary
from employees
where salary >(
SELECT salary
FROM employees 
WHERE last_name='Abel'
);

#案例2、返回job_id与141员工的job_id相同，salary比143号员工多的员工名，job_id和工资

select last_name,job_id,salary
from employees
where job_id=(
select job_id 
from employees
where employee_id=141
)
and salary > (
	select salary
	from employees
	where employee_id=143);
	
#案例3、返回公司工资最少的员工的last_name,job_id和salary

select last_name,job_id,salary
from employees
where salary=(
select min(salary)
from employees
);

#案例4、查询最低工资大于50号部门最低工资的部门id和其最低工资
#(1) 50号部门的最低工资
select min(salary)
from employees
where department_id =50;
#(2)每个部门的最低工资	
select min(salary),department_id
from employees
group by department_id;
#(3) 在（2）的基础上查询最低工资大于50号部门最低工资的部门id和其最低工资
SELECT MIN(salary),department_id
FROM employees
GROUP BY department_id
having min(salary) >(
SELECT MIN(salary)
FROM employees
WHERE department_id =50
);

#不能非法使用标量子查询

#2.列子查询 

#案例1：返回location_id是1400或1700的部门中的所有员工姓名

#(1) 查询location_id是1400或1700的部门编号
	select department_id
	from departments 
	where location_id in('1400','1700');
#(2)在一的基础上查询姓名
select last_name
from employees
where department_id =any(
	SELECT department_id
	FROM departments 
	WHERE location_id IN('1400','1700')
)

#案例2：返回其他部门中比job_id为‘IT_PROG’部门任一工资低的员工的员工号、姓名、job_id 以及salary

select salary
from employees
where job_id='IT_PROG';

SELECT salary
FROM employees
WHERE job_id!='IT_PROG';

select last_name,employee_id,job_id,salary
from employees
where salary<any(
	SELECT salary
	FROM employees
	WHERE job_id='IT_PROG'
	)
	and job_id!='IT_PROG'
;

#3. 行子查询（结果集一行多列或多行多列）

#案例：查询员工编号最小并且工资最高的员工信息

select *
from employees
where (employee_id,salary)=(
	select min(employee_id),max(salary)
	from employees
	)


#二、select后面
/*
把子查询结果集当成一张表
*/

#案例：查询每个部门的员工个数

select count(*),department_name
from employees e right join departments d
on e.department_id=d.department_id
group by department_name

Select d.*,(
	SELECT COUNT(*)
	FROM employees e 
	where e.department_id=d.department_id
	
	)
from departments d

#三、from后面

#案例：查询每个部门的平均工资的工资等级
#先查每个部门的平均工资
select avg(salary),department_id
from employees
group by department_id

#
select ag_dep.*,j.grade_level
from (
	SELECT AVG(salary) e,department_id
	FROM employees
	GROUP BY department_id
	) ag_dep 
	inner join job_grades j
on ag_dep.e between `lowest_sal` and `highest_sal`

#四、exists后面（相关子查询）
/*
语法：
exists（完整的查询语句）
返回结果为0，1
有结果为1，无则为0
*/

#案例1：查询有员工的部门名

select department_name
from departments d
where exists(
	select *
	from employees e
	where d.`department_id`=e.`department_id`
	)