import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/*")//访问所有资源之前，都会执行该过滤器
public class filter01 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("我被执行了");
        //放行
        //filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("我回来了");

    }

    @Override
    public void destroy() {

    }
}
