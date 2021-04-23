import java.util.List;

public class UserServiceImpl implements UserService {
    /**
     * 接口实例化，也就是新声明一个userdao，他可以调用userdaoimpl中的所有方法
     */
    private UserDao dao=new UserDaoImpl();

    @Override
    public List<User> select() {
        /*调用Dao完成查询
        public List<User> findAll() {
            //使用JDBC操作数据库
            //1.定义sql
            String sql="select * from user";
            List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
            return users;

        }*/
        return dao.select();
    }

    @Override
    public List<User> add() {
        return dao.add();
    }
}
