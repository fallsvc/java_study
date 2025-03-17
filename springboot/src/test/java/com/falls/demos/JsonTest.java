package com.falls.demos;

import com.falls.demos.model.UserInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/30  11:20
 */
public class JsonTest {
    @Test
    public void testJSON(){
        System.out.println(1233);
    }
    @Test
    public void testJSON2(){
        System.out.println(4556);
    }
    @Test
    void testJsonObject1() throws JsonProcessingException {
        UserInfo userInfo=new UserInfo("zhangsan","lisi",20);
        ObjectMapper objectMapper=new ObjectMapper();
        // 转Json
        String s=objectMapper.writeValueAsString(userInfo);

        System.out.println(s);
    }

    @Test
    void testJsonObject2() throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        // Json转对象
        String s="{\"name\":\"zhangsan\",\"age\":20,\"id\":\"lisi\"}";
        // readValue先new UserInfo() 对象 再进行赋值 此时如果UserInfo没有无参构造时会报错
        UserInfo userInfo=objectMapper.readValue(s,UserInfo.class);

        System.out.println(userInfo);
    }
}
