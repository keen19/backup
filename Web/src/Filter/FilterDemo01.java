package Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class FilterDemo01 implements Filter {
    @Override
    public void destroy() {
        System.out.println("销毁。。。");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("被拦截前。。。");

        chain.doFilter(req, resp);
        System.out.println("被拦截后。。。");

    }

    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("初始化。。。");

    }

}
