import java.util.List;

/**
 *
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> select();

    /**
     * 删除用户信息
     * @return
     */
    public List<User> add();

}
