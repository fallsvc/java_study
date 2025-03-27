package com.fallsvc.mybatisplus.userinfotest;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.fallsvc.mybatisplus.mapper.UserInfoMapper;
import com.fallsvc.mybatisplus.model.UserInfo;
import org.apache.catalina.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/20  21:55
 */
@SpringBootTest
public class UserInfoTest {
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Test
    public void insert(){
        UserInfo userInfo=new UserInfo();
        userInfo.setPassword("123456");
        userInfo.setUserName("admin1");
        userInfoMapper.insert(userInfo);

    }
    @Test
    public void deleteById(){
        UserInfo userInfo=new UserInfo();
        userInfo.setPassword("123456");
        userInfo.setUserName("admin1");
        userInfoMapper.deleteById(4);

    }
    @Test
    public void updateById(){
        UserInfo userInfo=new UserInfo();
        userInfo.setPassword("12345633");
        userInfo.setUserName("admin111");
        userInfo.setId(5);
        userInfoMapper.updateById(userInfo);

    }
    @Test
    public void selectById(){
        UserInfo userInfo=new UserInfo();
        userInfo.setPassword("12345633");
        userInfo.setUserName("admin111");
        userInfo.setId(5);
        System.out.println(userInfoMapper.selectById(5));

    }
    @Test
    public void testQueryWrapper(){
        QueryWrapper<UserInfo> userInfoQueryWrapper=new QueryWrapper<UserInfo>()
                .select("id","user_name","password")
                .like("user_name","min");
        userInfoMapper.selectList(userInfoQueryWrapper).stream().forEach(System.out::println);
    }
    @Test
    public void testQueryWrapper2(){
        QueryWrapper<UserInfo> userInfoQueryWrapper=new QueryWrapper<UserInfo>();
                userInfoQueryWrapper.lambda().select(UserInfo::getId,UserInfo::getUserName,UserInfo::getPassword)
                .like(UserInfo::getUserName,"min");
        userInfoMapper.selectList(userInfoQueryWrapper).stream().forEach(System.out::println);
    }
    @Test
    public void testUpdateWrapper(){
        UserInfo userInfo=new UserInfo();
        userInfo.setDeleteFlag(0);
        UpdateWrapper<UserInfo> userInfoUpdateWrapper=new UpdateWrapper<UserInfo>().lt("id",6);
        userInfoMapper.update(userInfo,userInfoUpdateWrapper);
    }
    @Test
    public void testUpdateWrapper2(){
       UpdateWrapper<UserInfo> userInfoUpdateWrapper=new UpdateWrapper<UserInfo>().set("delete_flag","1").lt("id",6);
        userInfoMapper.update(userInfoUpdateWrapper);
    }
    @Test
    public void testUpdateWrapper3(){
       UpdateWrapper<UserInfo> userInfoUpdateWrapper=new UpdateWrapper<UserInfo>().set("delete_flag","1").in("id", List.of(1,2,5,8));
        userInfoMapper.update(userInfoUpdateWrapper);
    }
    @Test
    public void testUpdateWrapper4(){
       UpdateWrapper<UserInfo> userInfoUpdateWrapper=new UpdateWrapper<UserInfo>().setSql("delete_flag=delete_flag+1").in("id", List.of(1,2,5,8));
        userInfoMapper.update(userInfoUpdateWrapper);
    }
    @Test
    public void testDeleteByCondition(){
        QueryWrapper<UserInfo> queryWrapper=new QueryWrapper<UserInfo>().eq("id",8);
        userInfoMapper.delete(queryWrapper);
    }


}
