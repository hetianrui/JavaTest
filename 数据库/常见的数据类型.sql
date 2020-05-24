#常见的数据类型
/*
数值型：
	整型
	小数：定点数、浮点数
字符型：
	较短的文本：char、varchar
	较长的文本：text、blob（较长的数据）
日期型：
	
*/

#一、整型
/*
    分类：
    tinyint、small、mediumint、int/integer、bigint
    特点：
    （1）如果设置无符号和有符号，默认有符号，如果想设置无符号，需要添加unsigned关键字
    （2）如果插入的数值超出了整型的范围，会报out of range异常，并且插入临界值
    （3）如果不设置长度，会有默认的长度
         长度代表了显示的最大宽度，如果不够会用0进行左边填充，但必须搭配zerofill使用！
         
    */
    
#1.  
CREATE TABLE koko(
       id INT(3),
       A_id INT UNSIGNED
       );
SELECT * FROM koko; 
#二、小数
/*
分类：
	1.浮点型
	float(M,D);
	double(M,D);
	2.定点型
	decimal(M,D);
	dec(M,D);
特点：
	1.M为整数位数+小数位数
	  D为小数位数
	  所以整数位数==M-D
	2.M和D都可以省略
	  如果是decimal，则默认为10，D默认为0
	  如果是float和double，则会随着插入的数值的决定精度
	3.定点型的精度较高，如果要求插入数值的精度较高如货币运算等则考虑使用
	
#使用原则：所选择的类型越简单越好，能保存的数值越小越好

*/

# 三、字符型
/*
短文本：char、varchar
其他：
binary和varbinary用于保存较短的二进制
enum用于保存枚举
set用于保存集合

较长的文本:
text
blob（较大的二进制）

特点：
         语法         M的意思                       特点                空间      效率
char     char(M)     最大的字符数，可以省略默认为1  固定长度的字符数   比较耗费   高
varchar  varchar(M)  最大的字符数，不可以省略       可变长度的字符数   比较节省   低


*/
#enum只能插入里面定义的字符，且只允许单个插入
CREATE TABLE test_enum(

       val ENUM('1','2','3')
       );
DESC test_enum;
INSERT INTO test_enum VALUES('1');
INSERT INTO test_enum VALUES('1,2');
SELECT * FROM test_enum;

#set里面只能插入里面定义的字符，但可以插入多个
CREATE TABLE test_set(
         val SET('1','2'));
         
SELECT * FROM test_set;
INSERT INTO test_set VALUES('1');
INSERT INTO test_set VALUES('1,2,3');

#四、日期型
 /*
 
分类：
date 只保存日期
time 只保存时间
year 只保存年

datetime  保存日期+时间
timestamp 保存日期+时间

比较： 
            字节  范围        时区等的影响
datetime    8     1000-9999   不受
timestamp   4     1970-2038   受