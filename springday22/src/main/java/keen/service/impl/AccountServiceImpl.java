package keen.service.impl;

import keen.dao.AccountDao;
import keen.dao.impl.AccountDaoImpl;
import keen.domain.Account;
import keen.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


public class AccountServiceImpl implements AccountService {


    private AccountDao accountDao;

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() throws SQLException {
        return accountDao.findAllAccount();
    }

    @Override
    public Account findAccountById(Integer id) throws SQLException {
        return accountDao.findAccountById(id);
    }

    @Override
    public void saveAccount(Account account) throws SQLException {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        accountDao.updateAccount(account);
    }

    @Override
    public void deleteAccount(Integer id) throws SQLException {
        accountDao.deleteAccount(id);
    }


}
