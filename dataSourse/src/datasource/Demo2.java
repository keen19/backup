package datasource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo2 {
    public static void main(String[] args) throws SQLException {
        //1.获取datasourc
        DataSource ds=new ComboPooledDataSource();
        //2.获取连接
        for (int i = 0; i < 10; i++) {
            Connection conn=ds.getConnection();
            System.out.println(i+":"+conn);
        }
    }
}
