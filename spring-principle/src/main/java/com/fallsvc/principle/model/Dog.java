package com.fallsvc.principle.model;

import lombok.Data;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/16  19:37
 */

public class Dog {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
