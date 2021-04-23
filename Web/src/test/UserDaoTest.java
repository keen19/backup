package test;

import org.junit.Test;

public class UserDaoTest  {
    @Test
    public void testLogin(){
        User user=new User();
        user.setUsername("张三");
        user.setPassword("123");
        UserDao dao=new UserDao();
        User userTest=dao.login(user);
        System.out.println(userTest);

    }
}
