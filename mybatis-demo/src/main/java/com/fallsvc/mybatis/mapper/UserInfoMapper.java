package com.fallsvc.mybatis.mapper;

import com.fallsvc.mybatis.model.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/13  11:14
 */
@Mapper
public interface UserInfoMapper {
//    @Select("select * from user_info")
//    @Select("select id,username,password,age,gender,phone,"+
//            "delete_flag as deleteFlag,create_time as createTime," +
//            "update_time as updateTime from user_info;")
//    @Results(id="BaseMap",value = {
//            @Result(column = "delete_flag",property = "deleteFlag"),
//            @Result(column = "create_time",property = "createTime"),
//            @Result(column = "update_time",property = "updateTime")
//    })

    @Select("select * from user_info")
    List<UserInfo> selectAll();
//    @ResultMap(value = "BaseMap")
    @Select("select * from user_info where id= #{id}")
    UserInfo selectAllById(Integer id);
    @Select("select * from user_info where username=#{param1} and password=#{param2}")
    UserInfo selectAllBy(String username,String password);
    // # 预编译sql 提前预留参数位置
    @Select("select * from user_info where username=#{userName} and password=#{password}")
    UserInfo selectAllBy2(@Param("userName") String username, String password);
    // $ 及时sql 直接拼接 无''
    @Select("select * from user_info where username='${userName}' and password='${password}'")
    List<UserInfo> selectAllBy3(@Param("userName") String username, String password);


    @Options(useGeneratedKeys = true,keyProperty = "id")// 获取自增id
    @Insert("insert into user_info (username,password,age) VALUES (#{username},#{password},#{age});")
    Integer insertUser(UserInfo userInfo);
    @Options(useGeneratedKeys = true,keyProperty = "id")// 获取自增id
    @Insert("insert into user_info (username,password,age) VALUES (#{userInfo.username},#{userInfo.password},#{userInfo.age});")
    Integer insertUser2(@Param("userInfo") UserInfo userInfo);

    @Delete("delete from user_info where id=#{id}")
    Integer deleteUser(Integer id);

    @Update("update user_info set delete_flag=#{deleteFlag} where id=#{id}")
    Integer updateUser(UserInfo userInfo);

    @Select("select * from user_info order by id ${str}") // sql注入这个只能用$ 需要解决sql注入问题 1.不提供输入str接口（前端以按钮实现） 2.使用枚举类型规范str
    List<UserInfo> selectUserByAscDesc(String str);

    @Select("select * from user_info where username like CONCAT('%',#{userName},'%')")
    List<UserInfo> selectUserInfoByLike(String userName);
    @Insert("<script>insert into user_info" +
            "<trim suffixOverrides=\",\" prefix=\"(\" suffix=\")\"> // suffixOverrides除后缀为,  prefix加前缀 suffix加后缀"+
            "<if test=\"username!=null\">" +
            "username," +
            "</if>" +
            "<if test=\"password!=null\">" +
            "password,"+
            "</if>"+
            "<if test=\"age!=null\">" +
            "age," +
            "</if>" +
            "<if test=\"gender!=null\">" +
            "gender," +
            "</if>" +
            "<if test=\"phone!=null\">" +
            "phone" +
            "</if>" +
            "        </trim>" +
            "        values" +
            "        <trim suffixOverrides=\",\" prefix=\"(\" suffix=\")\">\n" +
            "        <if test=\"username!=null\">\n" +
            "            #{username},\n" +
            "        </if>\n" +
            "        <if test=\"password!=null\">\n" +
            "            #{password},\n" +
            "        </if>\n" +
            "        <if test=\"age!=null\">\n" +
            "            #{age},\n" +
            "        </if>\n" +
            "        <if test=\"gender!=null\">\n" +
            "        #{gender},\n" +
            "        </if>\n" +
            "        <if test=\"phone!=null\">\n" +
            "            #{phone}\n" +
            "        </if>\n" +
            "        </trim></script>")
    Integer insertUser3(UserInfo userInfo);
}
