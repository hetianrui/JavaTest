#进阶2：条件查询
/*
语法： 
seclect 查询列表
from 表名
where 筛选条件；

分类：
     一、按条件表达式筛选
     简单条件运算符： > < = != <> >= <=
     
     二、按逻辑表达式筛选
     逻辑运算符：
            JAVA: && || !
           MySQL: and or not
     三、模糊查询
            like
            between and
            in
            is null
           */
  #一、按条件表达式筛选
  #案例一：查询工资>12000的员工信息
  
SELECT
	*
FROM
	employees
WHERE
	salary>12000;
#案例2：查询部门编号不等于90号的员工名和部门编号
SELECT
	last_name,
	department_id
FROM
	employees
WHERE
	department_id<>90;
#二、按逻辑表达式筛选
#案例1：查询工资z在10000到20000之间的员工名、工资以及奖金
SELECT
	last_name,
	salary,
	commission_pct
FROM
	employees
WHERE
	salary<20000 AND salary>10000;
#案例2：查询部门编号不是在90到110之间，或者工资高于15000的员工信息
SELECT
	*
FROM
	employees
WHERE
	NOT(department_id BETWEEN 90 AND 110) OR salary>15000;
#三、模糊查询
/*
like
between and
in
is null | is not null
*/
#1.like
#案例1：查询员工名中包含字符a的员工信息
SELECT
	*
FROM 
	employees
WHERE
	last_name LIKE "%a%";# %代表多个不确定的字符
	
#案例2：查询员工名中第三个字符为e，第五个字符为a的员工名和工资
SELECT
	last_name,salary
FROM
	employees
WHERE
        last_name LIKE '__n_l%'; #一个下划线代表一个不确定的字符
        
#案例3：查询员工名中的第二个字符为_的员工名
SELECT
	last_name,salary
FROM
	employees
WHERE
        last_name LIKE '_\_%'; 
        #当有关键字符时，用转义字符表示，可用ESCAPE指定自己的转义字符
        #例如：
SELECT
	last_name,salary
FROM
	employees
WHERE
	last_name LIKE '_5_%' ESCAPE '5';
#2. between and
/*
（1）提高简洁度
（2）包含临界值
（3）两边不能颠倒
*/
#案例1：查询员工编号在100到120之间
SELECT
	*
FROM
	employees
WHERE
	employee_id BETWEEN 100 AND 120;
#3.in
/*
含义：判断某字段的工种编号是否属于in列表中的某一项
（1）提高简洁度
（2）in列表的值类型必须一致或兼容
（3）不支持通配符
*/
#案例：查询员工的工种编号是AD_VP，IT_PROT中的任意一个的员工名字和工种编号
SELECT
	last_name,job_id
FROM
	employees
WHERE
	job_id IN ('AD_VP','IT_PROG' );
#4.is null
#案例1：查询没有奖金的员工名和奖金率

SELECT
	last_name,
	commission_pct
FROM
	employees
WHERE
	commission_pct IS NULL;
#安全等于<=>
SELECT
	last_name,
	commission_pct
FROM
	employees
WHERE
	commission_pct <=> NULL;
#is null 与<=>的区别
/*
is null: 仅仅可以判断null值，可读性较高，建议使用
<=>    : 既可以判断null值，又可以判断普通的数值，可读性低，不建议使用 
*/
SELECT 
	*
FROM
	employees
WHERE
	commission_pct LIKE "%%" AND last_name LIKE "%%";