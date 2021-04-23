package keen;

//import javax.annotation.Resources;

import keen.dao.UserDao;

import keen.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MybatisTest {
    InputStream in;
    SqlSessionFactoryBuilder builder;
    SqlSession session;
    UserDao userDao;

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
        userDao = session.getMapper(UserDao.class);

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
     * 查询所有用户信息
     */
    @Test
    public void testFindAll() {
        //使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);

        }

    }

    @Test
    public void testInsertUser(){
        //设置添加的用户数据
        User user = new User();
        user.setUsername("张三");
        user.setSex("男");
        user.setAddress("上海浦东区");
        user.setBirthday(new Date());

        //执行测试方法
        userDao.addUser(user);

    }

    /**
     * 测试修改方法
     */
    @Test
    public void testUpdateUser(){
        //设置修改的用户数据
        User user = new User();
        user.setId(51);
        user.setUsername("二狗");
        user.setAddress("佛山");
        user.setSex("女");
        user.setBirthday(new Date());

        //执行测试方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除方法
     */
    @Test
    public void testDeleteUser(){
        //执行测试方法
        userDao.deleteUser(52);
    }

    /**
     * 测试查询id方法
     */
    @Test
    public void testFindById(){
        //执行测试方法
        User byId = userDao.findById(51);
        System.out.println(byId);
    }

    /**
     * 测试模糊查询方法
     */
    @Test
    public void testFindByName(){
        List<User> users=userDao.findUserByName("狗");
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 查询用户数
     */
    @Test
    public void testFindTotal(){
        int total=userDao.findTotal();
        System.out.println(total);
    }
}
