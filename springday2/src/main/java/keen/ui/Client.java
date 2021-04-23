package keen.ui;


import keen.dao.AccountDao;
import keen.service.AccountService;
import keen.service.impl.AccountServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;



public class Client {
    public static void main(String[] args) {
        //获取核心容器对象
        ClassPathXmlApplicationContext accountService = new ClassPathXmlApplicationContext(
                "bean.xml");
        //根据id获取Bean对象,两种方式
        AccountService as = (AccountService) accountService.getBean("accountService");
//        AccountDao adao = accountService.getBean("accountDao", AccountDao.class);
        System.out.println(as);
        as.saveAccount();

    }
}
