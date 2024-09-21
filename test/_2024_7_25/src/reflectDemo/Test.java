package reflectDemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/25  14:46
 */
public class Test {
    public static void reflectNewInstance(){
        try{
            //forName("address") 方法拿类
            Class<?> c1=Class.forName("reflectDemo.Student");

            Student student=(Student) c1.newInstance();

            System.out.println(student);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public static void reflectPrivateConstructor(){
        try{
            Class<?> c1=Class.forName("reflectDemo.Student");
//            Class<?> c2=Student.class;
            Constructor<Student> constructor=(Constructor<Student>)c1.getDeclaredConstructor(String.class,int.class);
            constructor.setAccessible(true);

            Student student=constructor.newInstance("zs",20);

            System.out.println(student);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void reflectPrivateField(){
        try{
            Class<?> c1=Class.forName("reflectDemo.Student");
            Field field=c1.getDeclaredField("name");
            field.setAccessible(true);
            Student student=(Student) c1.newInstance();
            field.set(student,"sadf");
            System.out.println(student);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
    public static void reflectPrivateMethode(){
        try{
            Class<?> c1=Student.class;
            Method method= c1.getDeclaredMethod("function", String.class);
            method.setAccessible(true);
            Student student=(Student) c1.newInstance();
            method.invoke(student,"ws参数");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main1(String[] args) {
//        reflectNewInstance();
//        reflectPrivateConstructor();
//        reflectPrivateField();
        reflectPrivateMethode();
    }

    public static void main(String[] args) {
        try {
            //forName()
            Class<?> c1=Class.forName("reflectDemo.Student");
            //类名.class
            Class c2=Student.class;
            //对象.getClass()
            Student student=new Student();
            Class<?> c3=student.getClass();

            //只有一个类class
            System.out.println(c1.equals(c2));
            System.out.println(c2.equals(c3));
            System.out.println(c3.equals(c1));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
