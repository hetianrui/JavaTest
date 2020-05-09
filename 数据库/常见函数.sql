#进阶4：常见函数
/*
类似于java方法
分类：
1. 单行函数
如 concat、length、ifnull等
2. 分组函数
做统计使用，又称为统计函数、聚合函数、组函数

*/

#一、字符函数
#1. length()字节长度函数
SELECT LENGTH('jhon'); 
SELECT LENGTH('张三');#一个汉字三个字节

#2.  concat() 拼接字符串
SELECT CONCAT(last_name,'_',first_name) 姓名
FROM employees;
#3. upper、lower
SELECT UPPER('kok');
#案例：查询员工姓名，其中姓的字母大写
SELECT CONCAT(UPPER(last_name),'_',first_name) 姓名
FROM employees;

#4. substr,java里的substring
# 但是索引是从1开始的

# 参数列表为两个的时候，表示从指定位置到最后的字符

SELECT SUBSTR('李莫愁在哪里',4);

# 参数列表为三个的时候，substr('',a,b) 表示从索引a开始长度为b的字符

SELECT SUBSTR('Hello World',7,1);

#5. instr 返回子串第一次出现的索引，如果找不到返回0

SELECT INSTR('Hello World','ld');

#6.trim 去前后空格或别的字符
SELECT TRIM('a'FROM'aaaaHHHaaaa');

#7.lpad 用指定的字符实现左填充指定长度

SELECT LPAD('hi',10,'*');

#8.rpad 用指定的字符实现右填充指定长度

#9.replace 替换 

SELECT REPLACE('小明吃了小红的苹果，所以小红哭了','小红','小绿');

#二、数学函数

#round 四舍五入
SELECT ROUND(-1.65);
SELECT ROUND(1.23623,3); #3表示小数点保留几位

#ceil 向上取整，返回>=该参数的最小整数

SELECT CEIL(1.3);

#floor 向下取整,返回<=该参数的最大整数

SELECT FLOOR(3.6);

#truncate 截断: 小数点后保留几位

SELECT TRUNCATE(1.6333,3);

#mod 取余

SELECT MOD(-10,3);#被取余数是正是负，结果就是正是负。原理：a-a/b*b;

#三、日期函数

#now 返回当前系统日期+时间
SELECT NOW();

#curdate 返回当前系统日期，不包含时间

SELECT CURDATE();

#curtime 返回当前时间，不包含日期

SELECT CURTIME();

#可以获取指定的部分，年月日小时分钟秒
SELECT DISTINCT MONTH(hiredate) FROM employees;

#str_to_date:将字符转换成日期

SELECT STR_TO_DATE('3-2 5655','%c-%d %y');

#date_format 将日期转换成字符

SELECT DATE_FORMAT(NOW(),'%Y年%c月%d日');

# 查询有奖金的员工名和入职日期（月/日 年）
SELECT last_name,DATE_FORMAT(hiredate,'%c月/%d日 %Y年')
FROM employees
WHERE
	commission_pct IS NOT NULL;

#四、其他函数

SELECT VERSION();#查看当前数据库版本
SELECT DATABASE();#查看当前库
SELECT USER();#查看当前用户

#五、流程控制函数

#1. if函数 java里的三元运算符
# 表达式成立返回yes，不成立返回no
SELECT IF(10<5,'yes','no');


#2. case函数的使用一：switch case的效果
/*
语法：
case 要判断的字段或表达式
when 常量一 then 要显示的值或语句
when 常量二 then 要显示的值或语句
...
else 要显示的值或语句;
end
*/
SELECT salary 原始工资,
CASE department_id
WHEN 30 THEN salary*1.1
ELSE salary
END AS 新工资
FROM employees;
#3. case函数的使用二：类似于 多重if
/*
case
when 条件一 then 结果值或语句 如果为语句加;
when 条件一 then 结果值或语句
when 条件一 then 结果值或语句
...
else 结果值或语句
end
*/
#案例：查询员工的工资情况
/*>20000,级别A
>15000,B
>10000,C
否则 D
*/
SELECT last_name,salary,
CASE
WHEN salary>20000 THEN 'A'
WHEN salary>15000 THEN 'B'
WHEN salary>10000 THEN 'C'
ELSE "D"
END 工资级别
FROM employees;