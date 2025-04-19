package com.fallsvc.principle;

import com.fallsvc.principle.model.Person;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/19  22:27
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> aclass=Class.forName("com.fallsvc.principle.model.Person");
        Object o = aclass.getDeclaredConstructor().newInstance();
        System.out.println(o);

        Object o1=aclass.getDeclaredConstructor(String.class).newInstance("张三");
        System.out.println(o1);

        Method printNum = aclass.getDeclaredMethod("printNum", Integer.class);
        printNum.setAccessible(true);
        printNum.invoke(o1,5);

        Field field=aclass.getDeclaredField("name");
        field.setAccessible(true);
        Object o2=aclass.newInstance();
        Person person=(Person)o2;
        field.set(person,"小米");
        System.out.println(field.get(person));
    }
}
