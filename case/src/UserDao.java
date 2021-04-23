import java.util.List;

/**
 * 用户操作的Dao
 */
public interface UserDao {
    /**
     * 查询所有用户信息语句
     * @return
     */
    public List<User> select();

    /**
     * 删除语句
     * @return
     */
    public List<User> add();
}
