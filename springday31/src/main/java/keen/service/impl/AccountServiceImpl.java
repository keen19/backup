package keen.service.impl;

import keen.dao.AccountDao;
import keen.dao.impl.AccountDaoImpl;
import keen.domain.Account;
import keen.service.AccountService;
import keen.uitls.TransactionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


public class AccountServiceImpl implements AccountService {


    private AccountDao accountDao;
    private TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public AccountDao getAccountDao() {
        return accountDao;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAllAccount() throws SQLException {
        try{
            //1.开启事务
            transactionManager.beginTransaction();
            //2.执行操作
            List<Account> accounts=accountDao.findAllAccount();
            //3.提交事务
            transactionManager.commit();
            //4.返回结果
            return  accounts;
        }catch (Exception e){
            //5.回滚事务
            transactionManager.rollback();
            throw  new  RuntimeException();
        }finally {
            //6.释放连接
            transactionManager.release();
        }
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

    @Override
    public void tranfer(String sourceName, String targetName, float money) {
        //1.根据名称查询转出账户
        //2.根据名称查询转入账户
        //3.转出账户减钱
        //4.转入账户加钱
        //5.更新转出账户
        //6.更新转入账户
    }

    @Override
    public Account findAccountByName(String accountName) {
        return null;
    }


}
