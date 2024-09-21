package org.deom1;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/20  22:39
 */
public class DbUtil {
    public static DataSource dataSource;
    public static final String URL="jdbc:mysql://127.0.0.1:3306/java113?characterEncoding=utf8" +
            "&allowPublicKeyRetrieval=true&useSSL=false";
    public static final String USER="root";
    public static final String PASSWORD="123456";

    static {
        MysqlDataSource mysqlDataSource=new MysqlDataSource();
        mysqlDataSource.setURL(URL);
        mysqlDataSource.setUser(USER);
        mysqlDataSource.setPassword(PASSWORD);
        dataSource=mysqlDataSource;
    }

    private DbUtil() {
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void close(ResultSet resultSet, Statement statement,Connection connection) {

            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }


}
