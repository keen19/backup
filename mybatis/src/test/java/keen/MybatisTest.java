package keen;

//import javax.annotation.Resources;

import keen.dao.UserDao;
import keen.domain.QueryVo;
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
    public void selectUser() {
        //使用代理对象执行方法
        List<User> users = userDao.findAll();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getAccounts());
        }

    }

    /**
     * 增加用户
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("mybatis test save");
        user.setAddress("广州市海珠区");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存前:" + user);
        //执行增加方法
        userDao.saveUser(user);

        System.out.println("保存后:" + user);
    }

    /**
     * 更新用户信息
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(48);
        user.setUsername("mybatis test update");
        user.setAddress("广州市海珠区");
        user.setSex("男");
        user.setBirthday(new Date());
        //执行增加方法
        userDao.updateUser(user);
    }

    /**
     * 根据ID删除用户信息
     */
    @Test
    public void testDelete() {
        userDao.deleteUser(48);
    }

    /**
     * 查询用户
     */
    @Test
    public void testFindOne() {
        User user = userDao.findById(49);
        System.out.println(user);
    }

    /**
     * 查询用户,模糊查询
     */
    @Test
    public void testFindByName() {
        List<User> user = userDao.findByName("%王%");
        for (User user1 : user) {
            System.out.println(user1);
        }
    }

    /**
     * 查询用户
     */
    @Test
    public void testFindTotal() {
        int count = userDao.findTotal();
        System.out.println(count);
    }

    /**
     * 测试使用QueryVo
     */
    @Test
    public void testFindByVo(){
        QueryVo vo=new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        List<User> u = userDao.findUserByVo(vo);
        for (User user1 : u) {
            System.out.println(user1);
        }
    }

    /**
     * 测试查询所有名字是 '老王' 的信息
     */
    @Test
    public void testFindByCondition(){
        User u = new User();
        u.setUsername("老王");
        List<User> users=userDao.findUserByCondition(u);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试id(41,42,43) 范围里的查询
     */
    @Test
    public void testFindInIds(){
        QueryVo queryVo = new QueryVo();
        List<Integer> list=new ArrayList<>();
        list.add(41);
        list.add(42);
        list.add(43);
        queryVo.setIds(list);

        List<User> users=userDao.findUserInIds(queryVo);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindAllUserToRole(){
        List<User> users=userDao.findAllUserToRole();
        for (User user : users) {
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }
}
