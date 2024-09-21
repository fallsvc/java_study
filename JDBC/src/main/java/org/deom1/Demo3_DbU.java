package org.deom1;

import java.math.BigDecimal;
import java.sql.*;
import java.text.MessageFormat;
import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/21  10:47
 */
public class Demo3_DbU {
    public static void main(String[] args) {


        Connection connection=null;
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        try {
            //获取连接
            connection=DbUtil.getConnection();
            //
            String sql="select id,name,math from exam where name=?";
            statement=connection.prepareStatement(sql);

            Scanner scanner=new Scanner(System.in);

            while(scanner.hasNext()){
                String name=scanner.next();
                //真实值替换占位符？
                statement.setString(1,name);
                resultSet = statement.executeQuery();
                while(resultSet.next()){
                    Long id=resultSet.getLong(1);
                    String tname=resultSet.getString(2);
                    BigDecimal math=resultSet.getBigDecimal(3);
                    System.out.println(MessageFormat.format("id={0},name={1},math={2}", id, tname, math));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
