package com.falls.demos;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/24  17:23
 */

import lombok.*;

// lombok注解

/**
 *@AllArgsConstructor  // 全参构造方法
 * @NoArgsConstructor  // 无参构造方法
 * @Getter             // get
 * @Setter             // set
 */
@Data
public class UserInfo {
    private String name;
    private String Id;
    private int age;
    public UserInfo(){

    }
    public UserInfo(String name, String id, int age) {
        this.name = name;
        Id = id;
        this.age = age;
    }

    public static void main(String[] args) {
        UserInfo userInfo=new UserInfo();
        userInfo.setAge(10);
        System.out.println(userInfo);
    }
}
