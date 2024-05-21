package cn.falls.reflect;

import cn.falls.Domain.Person;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/21  21:14
 */
public class ReflectDemo1 {
    //获取class对象方法
    //

    public static void main(String[] args) throws Exception {
        //1.
        Class cls1=Class.forName("cn.falls.Domain.Person");
        System.out.println(cls1);
        //2.
        Class cls2= Person.class;
        System.out.println(cls2);
        //3.
        Person p=new Person();
        Class cls3=p.getClass();
        System.out.println(cls3);
    }
}
