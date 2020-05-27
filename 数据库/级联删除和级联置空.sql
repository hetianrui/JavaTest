#使用前提：删除含有外键的数据。得先删除从表（设置外键的是从表）的数据，再删主表
#所以要想先删除主表的数据，有以下两种方式
#一、级联删除：在删除主表数据的情况下，将从表的关联数据也删除

SHOW CREATE TABLE stuinfo;
ALTER TABLE stuinfo DROP FOREIGN KEY fk_stuinfo;
ALTER TABLE stuinfo ADD CONSTRAINT fk_stuinfo FOREIGN KEY(majorId) REFERENCES major(id) ON DELETE CASCADE;

DELETE FROM major WHERE id=2;

INSERT INTO major VALUES(1,'计算机');
INSERT INTO major VALUES(2,'h5');
INSERT INTO major VALUES(3,'MySQL');

INSERT INTO stuinfo VALUES(1,'join','男',1,20,1);
INSERT INTO stuinfo VALUES(2,'join2','女',2,21,2);
INSERT INTO stuinfo VALUES(3,'join3','男',3,22,3);

DELETE FROM major WHERE id=1;
SELECT * FROM major;
SELECT * FROM stuinfo;
#二、级联置空：在删除主表的时候，将从表的外键关联列置空
ALTER TABLE stuinfo DROP FOREIGN KEY fk_stuinfo;
ALTER TABLE stuinfo ADD CONSTRAINT fk_stuinfo FOREIGN KEY(majorId) REFERENCES major(id) ON DELETE SET NULL;
DELETE FROM major WHERE id=2;

/*set autocommit=0;
start transaction;
INSERT INTO major VALUES(4,'join4');
savepoint a;
insert into major values(1,'join');
INSERT INTO major VALUES(2,'join2');
INSERT INTO major VALUES(7,'join7');
rollback;
select * from major;
show variables like 'autocommit';
INSERT INTO major VALUES(8,'joi8');
delete from major;
*/
