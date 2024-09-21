package org.deom1;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/20  20:41
 */
public class Demo2_dataSource {
    public static void main(String[] args) throws SQLException {
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
            String sql="select id,name,math from exam where name=?";
            preparedStatement=connection.prepareStatement(sql);

            Scanner scanner=new Scanner(System.in);
            while(scanner.hasNext()){
                String name=scanner.next();
                //真实值替换占位符？
                preparedStatement.setString(1,name);
                resultSet = preparedStatement.executeQuery();
                while(resultSet.next()){
                    Long id=resultSet.getLong(1);
                    String tname=resultSet.getString(2);
                    BigDecimal math=resultSet.getBigDecimal(3);
                    System.out.println(MessageFormat.format("id={0},name={1},math={2}", id, tname, math));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            if(connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
