package com.falls.demos;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/24  17:23
 */


public class UserInfo {
    private String name;
    private String Id;
    private int age;

    public UserInfo(String name, String id, int age) {
        this.name = name;
        Id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "name='" + name + '\'' +
                ", Id='" + Id + '\'' +
                ", age=" + age +
                '}';
    }
}
