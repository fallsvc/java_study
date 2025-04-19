package com.fallsvc.principle.model;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/19  22:26
 */
public class Person {
    private String name;
    public Person(){

    }

    public Person(String name) {
        this.name = name;
    }

    private void printNum(Integer num){
        System.out.println(num);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
