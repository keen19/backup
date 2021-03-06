package keen.dao;

import keen.domain.Account;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface AccountDao {
    /**
     * 查询所有用户,并获取每个用户所属的用户信息
     * @return
     */
    @Select("select * from account")
    @Results(id = "accountMap",value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "uid",property = "uid"),
            @Result(column = "money",property = "money"),
            @Result(column = "uid",property = "user",one = @One
                    (select = "keen.dao.UserDao.findById",fetchType = FetchType.EAGER))
    })
    List<Account> findAll();

    /**
     * 根据用户Id查询账户信息
     * @param userId
     * @return
     */
    @Select("select * from account where uid =#{userId}")
    List<Account> findAccountByUid(Integer userId);
}
