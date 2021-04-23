package request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Demo1")
public class Demo1 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1.获取请求方式：Get
        String method=request.getMethod();
        System.out.println(method);
        //2.获取虚拟目录：
        String contextPath=request.getContextPath();
        System.out.println(contextPath);
        //3.获取Servlet路径：
        String servletPath=request.getServletPath();
        System.out.println(servletPath);
        //4.获取get方式请求参数：name=zhanshan
        String queryString=request.getQueryString();
        System.out.println(queryString);
        //5.获取请求URI:
        String requestURI=request.getRequestURI();
        System.out.println(requestURI);
        StringBuffer requestURL=request.getRequestURL();
        System.out.println(requestURL);
        //6.获取协议及版本：HTTP/1.1
        String protocol=request.getProtocol();
        System.out.println(protocol);
        //7.获取客户机的IP地址
        String remoteAddr=request.getRemoteAddr();
        System.out.println(remoteAddr);
    }
}
