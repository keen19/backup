package keen;

import keen.dao.RoleDao;
import keen.dao.UserDao;
import keen.domain.Role;
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

public class RoleTest {
    InputStream in;
    SqlSessionFactoryBuilder builder;
    SqlSession session;
    RoleDao roleDao;

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
        roleDao = session.getMapper(RoleDao.class);

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

    @Test
    public void testFindAll(){
        List<Role> roles=roleDao.findAll();
        for (Role role : roles) {
            System.out.print(role);
            System.out.println(role.getUsers());
        }
    }
}
