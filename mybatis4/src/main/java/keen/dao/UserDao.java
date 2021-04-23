package keen.dao;


import keen.domain.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

/**
 * 用户的持久层接口
 *
 * @author keen1
 */
//开启二级缓存
@CacheNamespace(blocking = true)
public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
    @Results(id = "userMap",value = {
            //id = true为主键,column为数据库字段,property是实体类属性
            @Result(id = true,column = "id",property = "userId"),
            @Result(column = "username",property = "userName"),
            @Result(column = "address",property = "userAddress"),
            @Result(column = "sex",property = "userSex"),
            @Result(column = "birthday",property = "userBirthday"),
            @Result(property = "account",column = "id",
                    many = @Many(select = "keen.dao.AccountDao.findAccountByUid",
                    fetchType = FetchType.LAZY))
    })
    List<User> findAll();

    /**
     * 插入一名用户
     *
     * @param user
     */
    @Insert("insert into user(username,address,sex,birthday)" +
            "values(#{username},#{address},#{sex},#{birthday})")
    void addUser(User user);

    /**
     * 更新一名用户信息
     * @param user
     */
    @Update("update user set username=#{username}," +
            "address=#{address},sex=#{sex},birthday=#{birthday} " +
            "where id=#{id}")
    void updateUser(User user);

    /**
     * 删除一名用户
     * @param id
     */
    @Delete("delete from user where id=#{id}")
    void deleteUser(Integer id);

    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @Select("select * from user where id=#{id}")
    @ResultMap(value = "userMap")
    User findById(Integer id);

    /**
     * 模糊查询
     * @param username
     * @return
     */
    @Select("select * from user where username like #{username}")
//    @Select("select * from user where username like '%${value}%'")
    List<User> findUserByName(String username);

    /**
     * 查询用户数
     * @return
     */
    @Select("select count(*) from user")
    int findTotal();

}
