package keen.dao.impl;

import keen.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {

    @Override
    public void saveAccount() {
        System.out.println("保存了账户");
    }
}
