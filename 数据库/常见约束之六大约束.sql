#常见约束

/*

含义：一种限制，用于限制表中的数据，为了保证数据的准确和可靠性

分类：
六大约束：
	not null：非空，保证该字段不为空
	default：默认，用于保证该字段有默认值
	primary key：主键，用于保证该字段的值具有唯一性，可以为空
	比如学号，员工编号等
	unique：唯一，用于保证该字段的值具有唯一性，可以为空
	比如配偶
	check：检查约束【mysql不支持】
	比如年龄、性别
	foreign key：外键，用于限制两个表的关系，保证该字段的值必须来自主表的关联列的值
	       用法：在从表添加外键约束，用于引用主表中某列的值
	       比如学生表的专业编号，员工表的部门编号，员工表的工种编号  
	   
添加约束的时机：
	1.建表时
	2.修改表时
约束的添加分类：
	列级约束：
		六大约束语法上都支持，但外键约束没有效果
	表级约束：
		除了非空、默认，其他的都支持
*/
CREATE TABLE 表名(
       字段名  字段类型  列级约束
       字段名  字段类型,
       表级约束
);

#一、创建表时添加约束
#1.添加列级约束

/*
语法：
	直接在字段名和类型后面追加 约束类型即可
	只支持：默认、非空、主键、唯一
*/
CREATE DATABASE students;
DROP TABLE stuinfo;

CREATE TABLE stuinfo(
	id INT,
	stu_name VARCHAR(20) NOT NULL,
	gender CHAR(1),
	seat INT UNIQUE,
	age INT DEFAULT 0,
	majorId INT,
	PRIMARY KEY(id,stu_name),
	FOREIGN KEY(majorId) REFERENCES major(id) 
	)CHARSET utf8;
	INSERT INTO stuinfo VALUES(1,'joni','男',NULL,12,1);
	INSERT INTO stuinfo VALUES(2,'loni','女',NULL,13,1);
	INSERT INTO stuinfo VALUES(3,'joni','男',1,12,1);
	INSERT INTO stuinfo VALUES(4,'lily','女',1,13,1);
	SELECT * FROM stuinfo;
	SELECT major_name FROM stuinfo s INNER JOIN major m
	ON s.majorId=m.id;
	DROP TABLE major;
CREATE TABLE major(
	id INT PRIMARY KEY,
	major_name VARCHAR(20)
	)CHARSET utf8;
	INSERT INTO major VALUES(1,'计算机');
DESC stuinfo;
#查看stuinfo表中所有的索引，包括主键、外键、唯一
SHOW INDEX FROM stuinfo;

#2. 添加表级约束

/*
语法：在各个字段的最下面
【constraint 约束名】 约束类型（字段名）


主键和唯一的大对比：
		保证唯一性  是否允许为空   一个表中可以有多个   是否允许组合（多列合为一个主键，只有多列都一样时，视为重复）
	主键    ✔		✖		至多有一个	是，但不推荐
	唯一    ✔		✔		可以有多个	是，但不推荐
	
外键：
	1.要求在从表设置外键关系
	2.从表的外键列的类型和主表的关联列的类型要求一直或兼容，名称无要求
	3.主表的关联列必须是一个key（一般是主键或唯一）
	4.插入数据时，先插入主表，再删除从表
	删除数据时，先删除从表，再删除主表
	*/
#二、修改表时添加约束

/*
1.添加列级约束
alter table 表名 modify column 字段名 字段类型 新约束;

2.添加表级约束
alter table 表名 add 约束类型（字段名）【对外键来说这儿是外键的引用】;
例如添加外键：
alter table stuinfo add constraint fk_stuinfo foreign key(majorId) references major(id);
*/

#三、修改表时删除约束
DROP TABLE stuinfo;
CREATE TABLE stuinfo(
	id INT,
	stu_name VARCHAR(20) NOT NULL,
	gender CHAR(1),
	seat INT UNIQUE,
	age INT DEFAULT 0,
	majorId INT,
	PRIMARY KEY(id),
	CONSTRAINT fk_stuinfo FOREIGN KEY(majorId) REFERENCES major(id) 
	)CHARSET utf8;
SHOW INDEX FROM stuinfo;
SHOW CREATE TABLE stuinfo;
DESC stuinfo;
#1.删除非空约束
ALTER TABLE stuinfo MODIFY COLUMN stu_name VARCHAR(10) NULL;
#2.删除默认约束(不写就行)
ALTER TABLE stuinfo MODIFY COLUMN age INT;
#3.删除主键约束
ALTER TABLE stuinfo DROP PRIMARY KEY;
#4.删除唯一约束
ALTER TABLE stuinfo DROP INDEX seat;
#5.删除外键
ALTER TABLE stuinfo DROP FOREIGN KEY fk_stuinfo;