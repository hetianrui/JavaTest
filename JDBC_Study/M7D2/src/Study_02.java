import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.ibatis.DruidDataSourceFactory;
import jdk.nashorn.internal.scripts.JD;
import org.junit.Test;

import javax.sql.DataSource;
import java.io.*;
import java.sql.*;
import java.util.Properties;

public class Study_02 {
    @Test
    public void Update()  {
        int i = 0;
        Connection connnection=null;
        PreparedStatement ps=null;
        try {
            connnection = JDBCUtils.getConnnection();
            String sql="update customers set photo= ? where id= ?";
            ps = connnection.prepareStatement(sql);
            ps.setBlob(1,
                    new FileInputStream("C:\\Users\\asus\\Pictures\\Saved Pictures\\1473583284267.jpg"));
            ps.setObject(2,19);
            i = ps.executeUpdate();
            if(i!=0){
                System.out.println("Success");
            }else {
                System.out.println("Fail");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connnection,ps);
        }


    }
    @Test
    public void test(){
        Connection connnection=null;
        PreparedStatement ps=null;
        ResultSet resultSet=null;
        InputStream photo=null;
        FileOutputStream fo=null;
        try {
            connnection = JDBCUtils.getConnnection();
            String sql="select id,name,email,birth,photo from customers where id= ?";
            ps = connnection.prepareStatement(sql);
            ps.setInt(1,16);
            resultSet = ps.executeQuery();
            if(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                Date birth = resultSet.getDate("birth");
                customers customers=new customers(id,name,email,birth);
                System.out.println(customers);
            }
            photo = resultSet.getBinaryStream("photo");
            fo=new FileOutputStream("zhuyin.jpg");
            byte bu[]=new byte[1024];
            int len;
            while ((len=photo.read(bu))!=-1){
                fo.write(bu,0,len);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connnection,ps,resultSet);
            if(photo!=null){
                try {
                    photo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fo!=null){
                try {
                    fo.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Test
    public void InsertMore(){
        Connection connnection=null;
        PreparedStatement ps=null;
        try {
            connnection = JDBCUtils.getConnnection();
            connnection.setAutoCommit(false);
            String sql="insert into stu(stu_name) values (?)";
            ps = connnection.prepareStatement(sql);
            long a=System.currentTimeMillis();
            for (int i = 0; i <20000 ; i++) {
                ps.setObject(1,"name: "+(i+1));
                ps.addBatch();
                if(i%500==0){
                    ps.executeBatch();
                    ps.clearBatch();
                }

            }
            connnection.commit();
            System.out.println(System.currentTimeMillis()-a);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connnection,ps);
        }
    }
    public static void Update(Connection connection,String sql,Object...args){
        PreparedStatement ps = null;
        try {
            ps = connection.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                ps.setObject(i+1,args[i]);
            }
            int i = ps.executeUpdate();
            if(i!=0){
                System.out.println("Success");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(null,ps);
        }

    }
    @Test
    public void Pool(){
        Properties properties=new Properties();
        InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
        Connection connection = null;
        try {
            properties.load(is);
            DataSource dataSource =
                    com.alibaba.druid.pool.DruidDataSourceFactory.createDataSource(properties);
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(connection);


    }
    public static void main(String[] args) {
        Connection connnection=null;
        try {
            connnection = JDBCUtils.getConnnection();
            connnection.setAutoCommit(false);
            String sql="update user_table set balance=900 where user=?";
            Update(connnection,sql,"AA");
            System.out.println(10/0);
            String sql1="update user_table set balance=1100 where user=?";
            Update(connnection,sql1,"BB");
            connnection.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                connnection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        } finally {
            JDBCUtils.close(connnection,null);
        }
    }
}
