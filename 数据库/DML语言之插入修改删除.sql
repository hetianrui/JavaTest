/*DML语言

数据操作语言
插入：insert
修改：update
删除：delete

*/

#一、插入语句
#方式一、
/*
语法：
insert into 表名(列名,...) values(值1,...)

特点：1.插入的值的类型要与列的类型一致或兼容
      2.values的值与每一列一一对应
      3.不可以为null必须写值，可以为null的可以写null，或者列名和值名同时省略
      4.当列名太多时，可以省略列名，注意是全部省略，但值名要一一对应
      
*/

#方式二：
/*
语法：

insert into 表名
set 列名=值,列名=值...

*/

#两种方式的pk
#方式一支持插入多行，二不支持
INSERT INTO beauty
VALUES(...),(...);

#方式二支持子查询，二不支持

#意思是把查询到的信息插入进去，注意查询的列数要和插入的列数保持一致
INSERT INTO beauty(id,NAME,phone)
SELECT id,boyName,'13' 
FROM boys WHERE id<3;

#二、修改语句

/*
1.修改单表的记录
语法：
update 表名
set 列=新值,列=新值...
where 筛选条件
2.修改多表记录

sql99语法：
update 表名
inner | outer | left join 表名
on 连接条件 
set 列=新值,列=新值...
where 筛选条件

*/

#1.修改单表的记录
#案例1：修改beauty表中姓唐的女神电话为：1213
UPDATE beauty SET phone='1213'
WHERE NAME LIKE '%唐%';

#三、删除语句
/*
方式一：delete
语法：
1.单表的删除 ★
delete from 表名 where 筛选条件

2. 多表的删除

sql99：
delete 表（注意这里是删除哪个表的信息，就填哪个表，也可以都填，意思可以都删）
from 表1 inner | outer | left join 表2
on 连接条件 
where 筛选条件

方式二、truncate
语法:
 truncate table 表名; 
 将整个表的数据删除，不能加筛选条件
 
 */
 
 #delete：
 #1.单表的删除
 #案例: 删除手机号以9结尾的女神信息
 
 DELETE FROM beauty WHERE phone LIKE '%9';

#2.多表的删除

#删除黄晓明及他女朋友的信息
DELETE b,bo
FROM boy b
INNER JOIN beauty bo
ON b.id=bo.boyfriend_id
WHERE b.name='黄晓明';

#delete pk truncate

/*
1.delete 可以加where，后者不行
2.truncate删除，效率高一丢丢
3.假如要删除的表中有自增长列，
如果用delete删除后，再插入数据，自增长列的值从断点开始
而truncate删除后，再插入数据，自增长列的值从1开始
4.delete删除有返回值，就是显示多少行受影响
 truncate删除无返回值
5.truncate删除不能回滚，delete删除可以回滚
*/

