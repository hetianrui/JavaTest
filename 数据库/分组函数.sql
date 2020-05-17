#二、分组函数
/*
功能：用作统计使用，又称为聚合函数或统计函数或组函数

分类：
sum 求和、avg平均值、max最大值、min最小值、count计算个数
*/

#1.简单的使用

SELECT SUM(salary) FROM employees;

SELECT ROUND(AVG(salary),3) FROM employees;

SELECT MIN(salary) FROM employees;

SELECT MAX(salary) FROM employees;

SELECT COUNT(salary) FROM employees;

#2、参数支持哪些类型 
/*(1)sum、avg一般用于处理任何数值
     max、min、count可以忽略任何类型
  (2)以上分组函数都忽略null值
  (3)可以和distinct搭配使用
  (4)count函数的单独介绍
     一般使用count（*）用作统计行数
  (5)和分组函数一同查询的字段要求是group by后的字段
  
  */
  #3. count的详细介绍
  #一般用作count(*) 查询所有行数，也可放别的字段，null除外
  SELECT COUNT("") FROM employees;
  SELECT COUNT(1) FROM employees; #两个作用一样
  /*效率：
  MYISAM存储引擎下，count(*)的效率高
  INNODB存储引擎下，COUNT（*）和COUNT（1）的效率差不多，比count（字段）要高一些
  */
#6.和分组函数一同查询的字段有限制

SELECT DATEDIFF(NOW(),'2020-06-20');
#datediff为日期函数，前一个减后一个。

   
  
  