import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    public static Connection getConnection() throws Exception {
        InputStream resourceAsStream =
                ClassLoader.getSystemClassLoader().getResourceAsStream("a.properties");
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
        return connection;
    }
    public static void closeConnection(Connection connection, PreparedStatement ps){
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
    public static void closeConnection(Connection connection, PreparedStatement ps, ResultSet rs){
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
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
