package keen.service;

import keen.domain.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * 账户的业务层接口
 */
public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount() throws SQLException;

    /**
     * 根据id查询
     * @return
     */
    Account findAccountById(Integer id) throws SQLException;

    /**
     * 添加用户
     * @param account
     */
    void saveAccount(Account account) throws SQLException;

    /**
     * 更新用户
     * @param account
     */
    void updateAccount(Account account) throws SQLException;

    /**
     * 删除用户
     * @param id
     */
    void deleteAccount(Integer id) throws SQLException;

    /**
     * 转账
     * @param sourceName 转出账户
     * @param targetName 转入账户
     * @param money 转账金额
     */
    void tranfer(String sourceName,String targetName,float money);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return 如果有唯一的一个结果就返回,没有则返回null,超过一个则抛出异常
     */
    Account findAccountByName(String accountName);
}
