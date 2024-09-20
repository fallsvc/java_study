package org.deom1;

import java.sql.*;
import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/20  19:56
 */
public class Demo1_DriverManager {
    public static void main(String[] args) {

        Connection connection=null;
        Statement statement=null;
        ResultSet resultSet=null;
        try{

            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.连接数据库
            connection=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/java113?characterEncoding=utf8" +
                    "&allowPublicKeyRetrieval=true&useSSL=false", "root", "123456");
            //3. 创建Statement对象
            statement=connection.createStatement();
            //4. 定义、执行SQL
            Scanner scanner=new Scanner(System.in);
            String name=scanner.next();

            String sql="select * from exam";
            //获得结果集
            resultSet = statement.executeQuery(sql);//select ...
            //遍历结果
            //next() 返回boolean 值 是否有下一行
            while(resultSet.next()){
                resultSet.getLong(1);
            }



//            statement.executeUpdate(sql);//update insert delete
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {

        }
    }
}
