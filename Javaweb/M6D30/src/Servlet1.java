import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getParameter("username")+"：进入柜台1");

        request.setAttribute("username","有柜台一的章子");

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/servlet2");

        requestDispatcher.forward(request,response);

    }
}
