package keen.dao.impl;

import keen.dao.AccountDao;
import keen.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的持久层实现类
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private QueryRunner runner;


    @Override
    public List<Account> findAllAccount() throws SQLException {
        return runner.query("select * from account1",new BeanListHandler<Account>(Account.class));
    }

    @Override
    public Account findAccountById(Integer id) throws SQLException {
        return runner.query("select * from account1 where id=?",new BeanHandler<Account>(Account.class),id);
    }

    @Override
    public void saveAccount(Account account) throws SQLException {
        runner.update("insert into account1(name,money)values (?,?)",account.getName(),account.getMoney());
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        runner.update("update account1 set name=?,money=?where id=? ",account.getName(),account.getMoney(),account.getId());
    }

    @Override
    public void deleteAccount(Integer id) throws SQLException {
        runner.update("delete  from account1 where id =?",id);
    }
}
