package keen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 控制器类
 *
 * RequestMapping:
 *      属性:
 *          value: 指定路径
 *          method: 指定请求方式
 *          params: 指定必须有的参数
 *          如果value是 username=he, 那么返回的参数必须是username,并且值也必须是he
 *          headers: 指定必须包含的请求头
 *
 * 注意: 如果没设置String返回值给视图解析器,
 * 那么spring会自动把注解设置的value返回给视图解析器
 * @author keen1
 */
@Controller("helloController")
public class HelloController {
//    配置相对路径
    @RequestMapping(path = "/hello")
    public String sayHello(){
        System.out.println("Hello World!");
        return "success";
    }

    @RequestMapping(path = "/hello2" ,method = {RequestMethod.GET},params = "username")
    public String sayHello2(){
        System.out.println("你好!");
        return "success";
    }
}
