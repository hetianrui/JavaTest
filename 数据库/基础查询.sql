#基础查询
/*
语法：
select 查询列表 from 表名；
1.查询列表可以是：表中的字段、常量值、表达式、函数
*/
#1.查询表中的单个字段
SELECT last_name FROM employees;
#2.查询表中的多个字段
SELECT last_name,salary FROM employees;
#3.查询表中的所有字段
SELECT * FROM employees;  
#4.查询常量值
SELECT 100;
SELECT 'john'; #MySQL里面的单/多字符都是单引号
#5.查询表达式
SELECT 100%98;
#6.查询函数
SELECT VERSION(); 
#7.起别名
#AS可以省略
SELECT 100%98 AS 结果;

SELECT last_name AS 姓,first_name AS 名 FROM employees;
# 案例 ：查询salary，显示结果为 out put，因为out为关键字，所以用“”引起来
SELECT salary "out put" FROM employees;

#8.去重 DISTINCT
#案例：查询员工表中涉及到的所有的部门编号
SELECT DISTINCT department_id FROM employees;
#9.+号的作用
/*
只有一个功能：运算符
select 100+90; 两个操作数都为数值型，则做加法运算
select 'john'+90; 一方为字符型，试图将字符型数值转换成数值型
                  如果转换成功，则继续做加法运算
                  如果转换失败，则将字符数值转换成0
select null+10；只要一方为null，则结果肯定为null
#例如：查询员工名和姓名连接成一个字段，并显示为姓名
*/
#MySQL 中的拼接函数 CONCAT(a,b,c) AS 别名 结果显示为abc
SELECT CONCAT(last_name,first_name) 姓名
FROM employees;
#显示employees表中所有的列，各个列之间用逗号隔开，列头显示为OUT_PUT
SELECT CONCAT(`first_name`,",",`last_name`,',',`salary`) OUT_PUT FROM employees;