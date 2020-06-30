import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet2 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig a=getServletConfig();
        ServletContext servletContext = getServletContext();
        ServletContext servletContext1 = getServletContext();
        System.out.println(a.getInitParameter("username"));
        System.out.println(servletContext1.getInitParameter("name"));
        System.out.println(servletContext.getInitParameter("name"));
        //System.out.println("Get Method");
        System.out.println(servletContext.getInitParameter("username"));
        //'/'被服务器解析为http://ip:port/工程名，映射到IDEA的前面的工程的web目录
        System.out.println(servletContext.getRealPath("/"));
        //System.out.println(servletContext.getResourcePaths("/"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Post Method");
    }
}
