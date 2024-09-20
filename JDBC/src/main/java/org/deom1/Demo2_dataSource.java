package org.deom1;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/20  20:41
 */
public class Demo2_dataSource {
    public static void main(String[] args) {
        // 定义mysql数据源对象
        MysqlDataSource mysqlDataSource=new MysqlDataSource();
        //连接串
        mysqlDataSource.setURL("jdbc:mysql://127.0.0.1:3306/java113?characterEncoding=utf8" +
                "&allowPublicKeyRetrieval=true&useSSL=false");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("123456");

        //定义jdbc 数据源对象
        DataSource dataSource=mysqlDataSource;

        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            //获取数据库连接
            connection=dataSource.getConnection();
            //预处理sql
            String sql=" name=?";
            preparedStatement=connection.prepareStatement(sql);

            String name="";
            preparedStatement.setString(1,name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

        }
    }

}
