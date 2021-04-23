package keen;

import keen.domain.Account;
import keen.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class SpringTest {
    //获取容器
    ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
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
