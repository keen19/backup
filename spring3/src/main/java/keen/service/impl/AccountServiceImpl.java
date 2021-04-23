package keen.service.impl;

import keen.dao.AccountDao;
import keen.dao.impl.AccountDaoImpl;

import keen.service.AccountService;

/**
 * @author keen1
 */
public class AccountServiceImpl implements AccountService {
    AccountDao accountDao=new AccountDaoImpl();

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
