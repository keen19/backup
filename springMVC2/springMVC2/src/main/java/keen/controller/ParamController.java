package keen.controller;

import keen.domain.Account;
import keen.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 请求参数绑定
 * @author keen1
 */
@Controller
@RequestMapping("/param")
public class ParamController {
    /**
     * 请求参数绑定入门
     * @return
     */
    @RequestMapping("/testParam")
    public String testParam(String username){
        System.out.println("请求参数绑定");
        System.out.println(username);
        return "success";
    }

    /**
     * 请求参数绑定把数据封装到JavaBean的类中
     * @param account
     */
    @RequestMapping(path="/saveAccount2")
    public String saveAccount(Account account){
        System.out.println("用户名:"+ account.getUsername());
        System.out.println("密码: "+ account.getPassword());
        System.out.println("金额:"+account.getMoney());
        System.out.println("map集合"+account.getMap());
        System.out.println("list集合"+account.getList());
        return "success";
    }

    /**
     *
     * @param user
     * @return
     */
    @RequestMapping("/saveUser")
    public String saveUser(User user){
        System.out.println("用户:"+user.getUsername());
        System.out.println("年龄:"+user.getAge());
        System.out.println("生日:"+user.getDate());
        return "success";
    }

    /**
     * 获取servlet
     * @param
     * @return
     */
    @RequestMapping("/saveServlet")
    public String saveServlet(HttpServletRequest request, HttpServletResponse response){
        System.out.println("执行了...");
        HttpSession session=request.getSession();
        System.out.println(session);
        ServletContext servletContext = session.getServletContext();
        System.out.println(servletContext);
        return "success";
    }
}
