#进阶8：分页查询
/*
应用场景：当要显示的数据一页显示不全时 

语法：
	select 查询列表
	from 表1
	join 连接类型 表1
	on 连接条件
	where 筛选条件
	group by 分组字段
	having 分组后的筛选
	order by 排序字段
	limit 【offset】,size;
	
	offset要显示条目的起始索引（起始索引从0开始）
	size要显示的条目个数
特点：
	1.放在语句的最后
	2.要查询的页数page，条目个数size
	则语法为limit (page-1)*size,size;
*/

#案例1.查询前五条员工信息

select * from employees limit 0,5

#案例2.有奖金的员工信息，并且工资较高的前十名

select * 
from employees 
where commission_pct is not null
order by salary desc
limit 0,10;