package cn.falls.reflect;

import cn.falls.Domain.Person;

import java.lang.reflect.Field;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/21  21:41
 */
public class ReflectDemo2 {
    public static void main(String[] args) {
        Class cls1= Person.class;
        Field[] field=cls1.getFields();
        Person p=new Person();
        for (Field x :
                field) {
            System.out.println(field);
        }
    }
}
