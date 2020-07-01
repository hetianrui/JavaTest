import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.*;
import org.junit.Test;

public class Connection_Study {
    public static void main(String[] args) throws SQLException {
        //连接方式一：
        Driver driver = new com.mysql.jdbc.Driver();
        String url = "jdbc:mysql://localhost:3306/test";

        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        Connection com = driver.connect(url, info);
        System.out.println(com);

    }

    @Test
    public void test() throws Exception {
        //连接方式二
        //1.获取Driver对象
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver = (Driver) clazz.newInstance();
        String url = "jdbc:mysql://localhost:3306/test";

        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "123456");

        Connection com = driver.connect(url, info);
        System.out.println(com);
    }

    @Test
    public void test1() throws Exception {
        //连接方式三
        //用DriverManager代替Driver
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
        Driver driver =(Driver) clazz.newInstance();
        DriverManager.registerDriver(driver);
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/test", "root", "123456");
        System.out.println(connection);
    }

    @Test
    public void test2() throws Exception {
        //连接方式四
        //用DriverManager代替Driver
        Class clazz = Class.forName("com.mysql.jdbc.Driver");
//        Driver driver =(Driver) clazz.newInstance();
//        DriverManager.registerDriver(driver);
        //上述操作可以省略，因为Driver里有静态代码块注册了驱动
        Connection connection =
                DriverManager.getConnection
                        ("jdbc:mysql://localhost:3306/test", "root", "123456");

    }
    @Test
    public void test3() throws Exception{
        InputStream resourceAsStream =
                Connection_Study.class.getClassLoader().getResourceAsStream("a.properties");
        Properties properties=new Properties();
        properties.load(resourceAsStream);
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String url=properties.getProperty("url");
        String drv=properties.getProperty("driverclass");

        Class.forName(drv);
        Connection connection =
                DriverManager.getConnection
                        (url,user,password);
        System.out.println(connection);
    }
}
