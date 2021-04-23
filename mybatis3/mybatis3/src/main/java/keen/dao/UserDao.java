package keen.dao;


import keen.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 用户的持久层接口
 *
 * @author keen1
 */

public interface UserDao {
    /**
     * 查询所有用户
     *
     * @return
     */
    @Select("select * from user")
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
    User findById(Integer id);

    /**
     * 模糊查询
     * @param username
     * @return
     */
    //@Select("select * from user where username like #{username}")
    @Select("select * from user where username like '%${value}%'")
    List<User> findUserByName(String username);

    /**
     * 查询用户数
     * @return
     */
    @Select("select count(*) from user")
    int findTotal();

}
