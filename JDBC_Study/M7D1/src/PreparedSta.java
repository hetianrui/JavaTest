import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class PreparedSta {
    public void Update(String sql,Object...args){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                ps.setObject(i+1,args[i]);
            }
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
        }
        JDBCUtils.closeConnection(connection,ps);
    }
    @Test
    public void always(){
        String sql="update customers set name= ? where id= ? ";
        Update(sql,"Tom","19");
    }
    @Test//插入数据
    public void test() throws IOException {
        InputStream resourceAsStream=null;
        PreparedStatement ps=null;
        Connection connection=null;
        try {
            resourceAsStream =
                    ClassLoader.getSystemClassLoader().getResourceAsStream("a.properties");

            Properties properties=new Properties();
            properties.load(resourceAsStream);
            String clazz=properties.getProperty("driverclass");
            String url=properties.getProperty("url");
            String user=properties.getProperty("user");
            String password=properties.getProperty("password");
            Class.forName(clazz);
            connection=DriverManager.getConnection(url,user,password);

            String sql="insert into customers(name,email,birth)values(?,?,?)";
            ps = connection.prepareStatement(sql);

            ps.setString(1,"何天瑞");
            ps.setString(2,"htr@qq.com");
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = format.parse("1999-10-20");
            ps.setDate(3, new Date(date.getTime()));
            ps.execute();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } finally {
            if(resourceAsStream!=null){
                resourceAsStream.close();
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
    @Test
    public void test1() {
        Connection connection = null;
        PreparedStatement ps= null;
        try {
            connection = JDBCUtils.getConnection();
            String sql="update customers set name = ? where id= ?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,"Sam");
            ps.setInt(2,19);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection,ps);
        }

    }
    @Test
    public void test2(){
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            connection = JDBCUtils.getConnection();
            String sql="select * from customers where id = ? ";
            ps = connection.prepareStatement(sql);
            ps.setObject(1,1);
            rs = ps.executeQuery();
            if (rs.next()){
            int a=rs.getInt(1);
            String b=rs.getString(2);
            String c=rs.getString(3);
            Date d=rs.getDate(4);
            customers customers=new customers(a,b,c,d);
                System.out.println(customers);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection,ps,rs);
        }


    }
    public customers Quary(String sql,Object...args) {
        Connection connection=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        try {
            //获取连接
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            //处理占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i+1,args[i]);
            }
            resultSet = ps.executeQuery();
            //得到结果集的列数
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            if (resultSet.next()){
                customers cs=new customers();
                for (int i = 0; i < columnCount; i++) {
                    Object object = resultSet.getObject(i + 1);//获取结果的列值
                    String str=metaData.getColumnLabel(i+1);//获取列值的列名
                    Field field = customers.class.getDeclaredField(str);//用列名找到类中的属性
                    field.setAccessible(true);//防止属性私有，允许访问
                    field.set(cs,object);//属性.set(对象，属性值)
                }
                return cs;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection,ps,resultSet);
        }
        return null;
    }
    @Test
    public void test3(){
        String sql="select id,name,email,birth from customers where id= ? ";
        System.out.println(Quary(sql,10));

  }

}
