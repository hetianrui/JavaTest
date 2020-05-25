#TCL

/*
Transaction Control Language 事务控制语言

事务：
一个或一组sql语句组成一个执行单元，这个执行单元要么全部执行，要么全部不执行

事务的特性：
ACID
原子性：一个事务不可再分割，要么都执行要么都不执行
一致性：一个事务执行会使数据从一个一致状态切换到另外一个一致状态
隔离性：一个事务的执行不受其他事务的干扰
持久性：一个事务一旦提交，则会永久的改变数据库的数据


事务的创建
隐式事务：事务没有明显的开启和结束的标记
比如：insert、update
显示事务：事务具有明显的开启和结束的标记
前提：必须先设置自动提交功能为禁用
set autocommit=0;

步骤1：开启事务
set autocommit=0;
start transaction;[可选的]
步骤2：编写事务中的sql语句（select insert update delete）
语句1;
语句2；
...
步骤3：结束事务
commit;提交事务
rollback;回滚事务

多个事务的并发问题，两个事务t1，t2
脏读：t1读取了t2已更新但未提交的数据，t2回滚后，t1读取的内容就是临时且无效的
不可重复读：t1读取，t2更新了该字段，t1再次读取，值就不同了
幻读：t1读取一个字段，然后t2在插入一些新的行，t1再读，就会多出几行，类似幻觉？


*/
SHOW ENGINES;
SHOW VARIABLES LIKE 'autocommit';
/*
隔离级别：

1. 读未提交(read uncommitted)
   定义：允许事务读取未被其他事务提交的变更。脏读，不可重复读和幻读的问题都会出现
   
2.读已提交（read committed）
   定义：只允许事务读取已经被其他事务提交的变更。可以避免脏读，但不可重复读和幻读仍然可能出现

3.可重复读（repeatable read）
   定义：确保事务可以从一个字段中读取相同的值。在这个事务持续期间，禁止其他事务对这个字段进行更新
         可以避免脏读和不可重复读，但幻读的问题仍然存在

4.串行化（serializable）
   定义：确保事务可以从一个表中读取相同的行。在这个事务持续期间，禁止其他事务对该表
   执行插入，更新和删除操作。所有并发问题都可以避免，但性能十分低下。
   
*/

#查看当前的隔离级别
SELECT @@tx_isolation;
#演示savepoint（回滚点）的使用
SAVEPOINT a;#设置保存点a
ROLLBACK TO a;#回滚到a

#delete 和 truncate在使用事务时的区别

SET autocommit=0;
START TRANSACTION;
DELETE FROM `test_enum`;
COMMIT;
INSERT INTO `test_enum` VALUES(1);
SELECT * FROM `test_enum`
SHOW VARIABLES LIKE 'autocommit';

