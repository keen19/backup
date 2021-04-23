package keen.dao;

import keen.domain.Account;
import keen.domain.AccountUser;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有账户
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有用户 带用户名和地址
     * @return
     */
    List<AccountUser> findAllAccount();
}
