package keen;

import keen.dao.AccountDao;
import keen.dao.UserDao;
import keen.domain.Account;
import keen.domain.AccountUser;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class AccountTest {
    InputStream in;
    SqlSessionFactoryBuilder builder;
    SqlSession session;
    AccountDao accountDao;

    //测试开始前,初始化
    @Before
    public void init() throws IOException {
        //1.读取配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂
        builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //3.获取SqlSession对象
        session = factory.openSession();
        //4.使Dao接口的代理对象
        accountDao = session.getMapper(AccountDao.class);

    }

    //测试结束前,释放资源
    @After
    public void destory() throws IOException {
        //提交事务
        session.commit();
        //6. 释放资源
        session.close();
        in.close();
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll(){
        List<Account> accounts=accountDao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }

    @Test
    public void testFindAllAcount(){

        List<AccountUser> accountUsers=accountDao.findAllAccount();
        for (AccountUser accountUser : accountUsers) {
            System.out.println(accountUser);
        }
    }
}
