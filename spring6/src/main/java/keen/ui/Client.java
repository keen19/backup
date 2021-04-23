package keen.ui;


import keen.dao.AccountDao;
import keen.service.AccountService;
import keen.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * 获取spring的IOC核心容器,并根据Id获取对象
 *
 * ApplicationContext 的三个常用实现类:
 *      ClassPathXmlApplicationContext: 可以加载类路径下的配置文件,要求配置文件必须在类路径下
 *      FileSystemXmlApplicationContext: 可以加载磁盘任意路径下的配置文件
 *      AnnotationConfigApplicationContext: 用于读取注解创建容器
 *
 * ApplicationContext: 单例对象适用
 *          创建对象采用立即加载,读取配置文件完的同时就创建对象
 * BeanFactory: 多例对象适用
 *          创建对象采用延迟加载,根据id获取对象时才创建对象
 */
public class Client {
    public static void main(String[] args) {
        //获取核心容器对象
        ClassPathXmlApplicationContext accountService = new ClassPathXmlApplicationContext(
                "bean.xml");
        //根据id获取Bean对象,两种方式
        AccountService as = (AccountService) accountService.getBean("accountService");
//        AccountDao adao = accountService.getBean("accountDao", AccountDao.class);
        System.out.println(as);

//        System.out.println(adao);
//        accountService.close();
        as.saveAccount();

    }
}
