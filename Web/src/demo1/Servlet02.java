package demo1;

import javax.servlet.*;
import java.io.IOException;


/**
 * Servlet生命周期
 * 被创建：执行init方法，只执行一次
 * 提供服务：执行Service方法，可多次执行
 * 被销毁：执行destroy方法。
 */

public class Servlet02 implements Servlet {
    /**
     * 初始化方法
     * 在Servlet被创建时，执行，只会执行一次
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init........");
    }

    /**
     * 获取ServletConfig配置
     * @return
     */
    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 提供服务方法
     * 每次Servlet被访问时执行，执行多次
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service啊");

    }

    /**
     * 获取Servlet的信息：版本等
     * @return
     */
    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 销毁方法
     * 服务器正常关闭时执行
     */
    @Override
    public void destroy() {
        System.out.println("destory");

    }
}
