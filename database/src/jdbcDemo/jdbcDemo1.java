package jdbcDemo;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbcDemo1 {
    public static void main(String[] args) throws Exception {
        //1 导入jar包
        //2 注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3 获取数据库连接对象
        Connection connection=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/123",
                "root",
                "123");
        //4. 定义sql语句
        String sql="select * from users";
        //5 获取statement对象
        Statement sta=connection.createStatement();
        // 6 执行sql
//        int count = sta.executeUpdate(sql);
        ResultSet rs=sta.executeQuery(sql);
        //7处理结果
        while (rs.next()) {
            int id= rs.getInt(1);
            String name=rs.getString("username");
            String ps=rs.getString("password");
            System.out.println(id+"---"+name+"-----"+ps);
        }

        //8 释放资源
        sta.close();
        connection.close();
        rs.close();
    }
}
