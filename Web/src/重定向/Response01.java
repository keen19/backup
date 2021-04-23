package 重定向;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author keen1
 */
@WebServlet("/response01")
public class Response01 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("01被访问了");
/*        //访问/response01,会自动跳转到/response02资源
        //1.设置状态码302
        response.setStatus(302);
        //2.设置响应头location
        response.setHeader("location","/test/response02");*/

//        重定向方法
        response.sendRedirect("/test/response02");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
