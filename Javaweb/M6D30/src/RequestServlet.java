import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RequestServlet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("获取请求的资源路径: "+request.getRequestURI());
//        System.out.println("获取请求的统一资源定位符: "+request.getRequestURL());
//        System.out.println("客户端IP："+request.getRemoteHost());
        request.setCharacterEncoding("UTF-8");
        System.out.println(request.getParameter("username"));
        System.out.println(request.getParameter("password"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        System.out.println(req.getParameter("username"));
        System.out.println(req.getParameter("password"));
    }
}
