import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> select() {
        //使用JDBC操作数据库
        //1.定义sql
        String sql="select * from user";
        List<User> select_users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return select_users;

    }

    @Override
    public List<User> add() {
        //使用JDBC操作数据库
        //1.定义sql
        String sql="insert  into  user ";
        List<User> add_users=template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return add_users;
    }
}
