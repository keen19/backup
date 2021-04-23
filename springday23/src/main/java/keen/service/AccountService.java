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
}
