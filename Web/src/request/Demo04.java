package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo04")
public class Demo04 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //演示获取请求头数据：referer
        String referer=request.getHeader("referer");
        System.out.println(referer);
        if (referer!=null) {
            if (referer.contains("/test")) {
                System.out.println("播放电影。。");
            } else {
                System.out.println("盗版连接");
            }
        }
    }
}


