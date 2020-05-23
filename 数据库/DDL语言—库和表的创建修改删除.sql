#DDL
/*

数据定义语言：

一、库和表的管理
创建、修改、删除

二、表的管理
创建、修改、删除

创建：create
修改：alter
删除：drop
*/

#一、库的管理
#1. 库的创建

/*
语法：
create datebase [IF NOT EXISTS] 库名;

*/

CREATE DATABASE IF NOT EXISTS books;

#2. 库的修改

#更改库的字符集

ALTER DATABASE books CHARACTER SET gbk;
#或者
ALTER DATABASE books CHARSET gbk;

#3.库的删除

DROP DATABASE IF EXISTS books;

#2二、表的管理

#1. 表的创建

/*

create table 表名(
	列名 列的类型 【长度】,
	列名 列的类型 【长度】,
	列名 列的类型 【长度】,
...
*/

CREATE TABLE book1(

id INT,
b_name VARCHAR(20),
author_id INT,
publish_date DATETIME
)CHARSET 'utf8';
DROP TABLE book;

DESC book;

#2. 表的修改

/*
alter table 表名 修改关键词 列名 【类型】

*/
#（1）修改列名
ALTER TABLE book CHANGE COLUMN publish_date pub_date DATETIME; 
#（2）修改列的类型或约束
ALTER TABLE book MODIFY pub_date TIMESTAMP;
#（3）添加新列名
#加个年薪列
ALTER TABLE book ADD COLUMN annual DOUBLE;
#（4）删除列
ALTER TABLE book DROP COLUMN annual;
#（5）修改表名
ALTER TABLE boook RENAME TO book;

#3. 表的删除

DROP TABLE book;
SHOW TABLES;

INSERT INTO book VALUES(2,'小何的一生',3,'2020-05-20');
UPDATE book1 SET b_name='钢铁是怎样炼成的'
WHERE id=2;
SELECT * FROM book1;

#4.复制表

#复制表的结构

CREATE TABLE copy LIKE book1;

/*
语法：
create table 新表名 like 旧表名;

*/

#复制表的结构及数据

CREATE TABLE copy1 
SELECT * FROM book1;

#只复制部分数据

CREATE TABLE copy2 
SELECT id,b_name
FROM book1
WHERE id=2;

#只复制部分字段
CREATE TABLE copy3 
SELECT id,b_name
FROM book1
WHERE id=5;#筛选条件值为假的就行

###注意：可以跨库复制表结构
/*
语法：
create table 表名
select * from 旧表所在的库.旧表;
*/

#举例：把部门表的数据插入到books库的新表dep中

CREATE TABLE dep
SELECT * FROM myemployees.department;