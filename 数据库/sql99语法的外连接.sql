#外连接 
/*
意义：1.外连接的查询结果为主表中的所有记录
      如果从表中有和它匹配的，则显示匹配的值
      如果从表中没有和它匹配的，则显示null
      外连接查询结果=内连接结果+主表中有而从表没有的记录
      
      2.左外连接：left join左边的是主表
        右外连接：right join右边的是主表
      3.左外和右外交换两个表的顺序，可以实现同样的效果
      4.全外连接=内连接结果+表1有但表2没有的+表2有表1没有的
*/
SELECT g.name,boyName
FROM beauty g LEFT OUTER JOIN boys b
ON g.boyfriend_id=b.id;

#案例1.哪个部门没有员工

SELECT d.department_name,last_name
from departments d left outer join employees e
on d.`department_id`=e.`department_id`
where last_name is null;

#交叉连接

#笛卡尔乘积，两表行数相乘
select b.*,bo.*
from beauty b
join boys bo