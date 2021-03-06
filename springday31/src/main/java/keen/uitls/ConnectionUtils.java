package keen.uitls;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取线程上的连接
     *
     * @return
     */
    public Connection getThreadConnection() {
        //1.先从ThreadLocal上获取
        Connection conn = tl.get();
        try {
            //2.判断当前线程上是否有连接
            if (conn == null) {
                //3.从数据源中获取一个连接,并且存入ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            //4.返回当前线程上的连接
            return conn;
        } catch (Exception throwables) {
            throw new RuntimeException();
        }

    }

    /**
     * 把连接和线程解绑
     */
    public void removeConnection() {
        tl.remove();
    }
}
