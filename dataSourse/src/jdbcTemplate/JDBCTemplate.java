package jdbcTemplate;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import utils.JDBCUtils;

import java.util.Map;

/**
 * JDBCTemplate方法：
 * update():执行DML语句 增删改语句
 * queryForMap():查询结构将结果集封装为map集合
 * queryForList():查询结构将结果集封装为list集合
 * query():查询结果将结果集封装为javabean对象
 * queryForObject:查询结果，将结果集封装为对象
 */
public class JDBCTemplate {
    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql="update users set username = 'da' where userid=?";
        int count = template.update(sql, 6);
        System.out.println(count);
    }



}
