package keen.service.impl;

import keen.dao.AccountDao;
import keen.dao.impl.AccountDaoImpl;

import keen.service.AccountService;

import java.util.Date;

/**
 * @author keen1
 */
public class AccountServiceImpl implements AccountService {
    AccountDao accountDao=new AccountDaoImpl();

    private String name;
    private Integer age;
    private Date birthday;

//    public AccountServiceImpl( String name, Integer age, Date birthday) {
//        this.name = name;
//        this.age = age;
//        this.birthday = birthday;
//    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "AccountServiceImpl{" +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }

    public void init(){
        System.out.println("对象出生了");
    }
    public void destroy(){
        System.out.println("对象销毁");
    }
}
