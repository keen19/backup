package jdbcTemplate;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import utils.JDBCUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class JdbcTemplateDemo1 {
    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 修改一条记录
     */
    @Test
    public void test() {
        //1.获取JDBCTemplate对象
        //2.定义sql
        String sql = "update users set username='aaaaaaa' where userid=?";
        //3.执行sql
        int update = template.update(sql, 6);
        System.out.println(update);
    }

    /**
     * 添加一条记录
     */
    @Test
    public void test02() {
        String sql = "insert into users(userid,username,password) values(?,?,?)";
        int update = template.update(sql, 8, "qqq", "111");
        System.out.println(update);
    }

    /**
     * 查询userid为1的记录，将其封装为map集合
     * 查询的结果集只能是一条记录
     */
    @Test
    public void test03() {
        String sql = "select * from users where userid = ?";
        Map<String, Object> map = template.queryForMap(sql, 1);
        System.out.println(map);
        //{userid=1, username=张三, password=123456}
    }

    /**
     * 查询记录，将其封装为list集合
     * 将每一条记录封装为一个Map集合，再将Map集合装载到List集合
     */
    @Test
    public void test04() {
        String sql = "select * from users ";
        List<Map<String, Object>> map = template.queryForList(sql);
        for (Map<String, Object> stringObjectMap : map) {
            System.out.println(stringObjectMap);

        }
    }

    /**
     * 查询记录，将结果封装为Users对象的List集合
     */
    @Test
    public void test05() {
        String sql = "select * from users ";
        List<Users> users = template.query(sql, new RowMapper<Users>() {
            @Override
            public Users mapRow(ResultSet resultSet, int i) throws SQLException {
                Users users1 = new Users();
                int userid = resultSet.getInt("userid");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                users1.setUserid(userid);
                users1.setUsername(username);
                users1.setPassword(password);

                return users1;
            }
        });
        for (Users user : users) {
            System.out.println(user);
        }
    }

    /**
     * 上一条查询的快捷方法
     * List<Users> query = template.query(sql, new BeanPropertyRowMapper<Users>(Users.class));
     */
    @Test
        public void test06(){
            String sql = "select * from users ";
            List<Users> query = template.query(sql, new BeanPropertyRowMapper<Users>(Users.class));
            for (Users users : query) {
                System.out.println(users);
            }
        }
    /**
     * 查询总记录数
     */
    @Test
    public void test07(){
        String sql="select count(userid) from users";
        Long aLong = template.queryForObject(sql, Long.class);
        System.out.println(aLong);
    }
}

