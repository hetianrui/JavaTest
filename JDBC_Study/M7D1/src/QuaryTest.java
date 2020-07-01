import com.sun.deploy.util.SyncAccess;
import org.junit.Test;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuaryTest {
    //一行语句的不同表的通用查询
    public <P> P Search(Class<P> clazz,String sql,Object...args){
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
                P p = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object object = resultSet.getObject(i + 1);//获取结果的列值
                    String str=metaData.getColumnLabel(i+1);//获取列值的列名
                    Field field = clazz.getDeclaredField(str);//用列名找到类中的属性
                    field.setAccessible(true);//防止属性私有，允许访问
                    field.set(p,object);//属性.set(对象，属性值)
                }
                return p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection,ps,resultSet);
        }
        return null;
    }
    //多行语句的不同表的通用查询
    public <P> List<P> SearchMore(Class<P> clazz, String sql, Object...args){
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
            ResultSetMetaData metaData = resultSet.getMetaData();//打包结果集为一个元数据
            int columnCount = metaData.getColumnCount();//用元数据获得结果集的列数
            List<P> list=new ArrayList<>();
            while (resultSet.next()){
                P p = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    Object object = resultSet.getObject(i + 1);//获取结果的列值
                    String str=metaData.getColumnLabel(i+1);//获取列值的列名
                    Field field = clazz.getDeclaredField(str);//用列名找到类中的属性
                    field.setAccessible(true);//防止属性私有，允许访问
                    field.set(p,object);//属性.set(对象，属性值)
                }
                list.add(p);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection,ps,resultSet);
        }
        return null;
    }
    @Test
    public void test(){
        String sql="select name,id,email,birth from customers where id< ?";
        List<customers> list = SearchMore(customers.class, sql, 10);
        list.forEach(System.out::println);

    }
    @Test
    public void test1(){

    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("name: ");
        String s1=scanner.nextLine();
        System.out.println("email: ");
        String s2=scanner.nextLine();
        //scanner.nextLine();
        System.out.println("id: ");
        int s3=scanner.nextInt();
        String sql="update customers set name=?,email=? where id= ?";
        if(Update(sql,s1,s2,s3)!=0){
            System.out.println("Success");
        }else {
            System.out.println("Fail");
        }
    }
    public static int Update(String sql,Object...args){
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = JDBCUtils.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i <args.length ; i++) {
                ps.setObject(i+1,args[i]);
            }
            return ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.closeConnection(connection,ps);
        }
            return 0;
    }
}
