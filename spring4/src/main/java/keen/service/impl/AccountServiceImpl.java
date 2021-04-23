package keen.service.impl;

import keen.dao.AccountDao;
import keen.dao.impl.AccountDaoImpl;

import keen.service.AccountService;

/**
 * @author keen1
 */
public class AccountServiceImpl implements AccountService {
    AccountDao accountDao=new AccountDaoImpl();

    public AccountServiceImpl() {
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
