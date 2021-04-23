package ServletContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletContextDemo1")
public class ServletContextDemo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /**
         * ServletContext对象获取：
         * 1。 通过request对象获取
         *  request.getServletContext();
         *  2.通过HttpServlet获取
         *  this.getServletContext();
         */
        ServletContext sc=req.getServletContext();
        ServletContext sc2=this.getServletContext();
        System.out.println(sc);
        System.out.println(sc2);
        System.out.println(sc == sc2);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
