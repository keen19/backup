package keen;

import config.SpringConfiguration;
import keen.domain.Account;
import keen.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * 使用Junit单元测试,测试我们的配置
 * spring整合junit的配置
 *      1.导入spring整合junit的jar坐标
 *      2.使用junit提供的一个注解,把原有的main方法替换,
 *          @Runwith
 *      3.告知spring的运行器,spring和ioc创建时基于xml还是注解的,并说明配置
 *          @ContextConfiguration
 *              Locations:指定xml文件的位置,加上classpath关键字.表示在类路径下
 *              classes:指定注解类所在地位置
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:bean.xml")
public class SpringTest {
    //获取容器
//    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
    ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
    //得到业务层对象
    AccountService as=ac.getBean("accountService",AccountService.class);

    @Test
    public void testFindAll() throws SQLException {

        //执行方法
        List<Account> accounts=as.findAllAccount();
        for (Account account : accounts) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() throws SQLException {
        Account accounts =  as.findAccountById(5);
        System.out.println(accounts);
    }

    @Test
    public void testSaveAccount() throws SQLException {
        Account account = new Account();
        account.setName("你");
        account.setMoney(30f);
        as.saveAccount(account);
    }
    @Test
    public void testUpdateAccount() throws SQLException {
        Account account = new Account();
        account.setId(4);
        account.setName("wo");
        account.setMoney(100f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() throws SQLException {
        as.deleteAccount(4);
    }
}
