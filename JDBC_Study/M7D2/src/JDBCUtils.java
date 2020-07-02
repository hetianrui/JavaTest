import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    @Test
    public static Connection getConnnection()  {
        Connection connection= null;
        try {
            InputStream is=ClassLoader.getSystemClassLoader().getResourceAsStream("a.properties");
            Properties properties=new Properties();
            properties.load(is);
            String user=properties.getProperty("user");
            String password=properties.getProperty("password");
            String url=properties.getProperty("url");
            String driverclass=properties.getProperty("driverclass");
            Class.forName(driverclass);
            connection = DriverManager.getConnection(url,user,password);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }
    public static void close(Connection connection, PreparedStatement ps,ResultSet resultSet){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static void close(Connection connection, PreparedStatement ps){
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
