#标识列
/*
又称为自增长列
含义：可以不用手动的插入值，系统提供默认的序列值
特点：
	1.标识列必须和主键搭配吗？不一定，但要求是一个key
	2.一个表可以有几个标识列？至多一个！
	3.标识列的类型只能是数值型
	4.标识列可以通过set auto_increment_increment=3; 设置步长
	可以通过手动插入值，设置起始值
*/
#一、创建表时设置标识列
DROP TABLE IF EXISTS tab_identity; 
CREATE TABLE tab_identity(
	id INT AUTO_INCREMENT,
	seat INT,
	PRIMARY KEY(id)
	);
	INSERT INTO tab_identity VALUES(NULL,1);
	SELECT * FROM tab_identity;
	DELETE FROM tab_identity WHERE id=8;
	truncate table tab_identity;
	delete from tab_identity;