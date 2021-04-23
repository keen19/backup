package keen.dao;

import keen.domain.QueryVo;
import keen.domain.Role;
import keen.domain.User;

import java.util.List;

//用户的持久层接口
public interface UserDao {
    /**
     * 查询所有接口
     * @return
     */
    //@Select("select * from user")
    List<User> findAll();

    /**
     * 增加用户
     * @param user
     */
    void saveUser(User user);

    /**
     * 删除用户
     * @param id
     */
    void deleteUser(Integer id);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据id查询
     * @param id
     * @return
     */
    User findById(Integer id);

    /**
     * 模糊查询
     * @return  username
     */
    List<User> findByName(String username);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();

    List<User> findUserByVo(QueryVo vo);

    /**
     * 根据传入参数条件
     * @param user 查询的条件:可能有用户名,性别等
     * @return
     */
    List<User> findUserByCondition(User user);

    /**
     * 根据queryvo中提供的ids集合,查询用户信息
     * @param queryVo
     * @return
     */
    List<User> findUserInIds(QueryVo queryVo);

    /**
     * 查询以user为主表,role为从表的所有信息
     * @return
     */
    List<User> findAllUserToRole();
}
