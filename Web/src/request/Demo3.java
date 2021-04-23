package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo03")
public class Demo3 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String agent=request.getHeader("user-agent");
        //判断agent的浏览器版本
        if (agent.contains("Chrome")){
            System.out.println("谷歌浏览器");
        }else if (agent.contains("Firefox")){
            System.out.println("火狐浏览器");
        }
    }
}

