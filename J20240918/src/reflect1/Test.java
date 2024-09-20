package reflect1;

import java.lang.reflect.Field;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/18  10:12
 */
public class Test {
    public static void main(String[] args) {
        try{
            Class<?> c=Class.forName("reflect1.Student");



            Field field=c.getDeclaredField("name");

            field.setAccessible(true);
            Student student=(Student) c.newInstance();
            field.set(student,"asdfg");

            System.out.println(student);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main1(String[] args) {
        try{
            Class<?> c=Class.forName("reflect1.Student");
//            Class student=Student.class;
//
//            Student student1=new Student();
//            Class<?> c2=student1.getClass();

            Student student=(Student)c.newInstance();//一定要有无参构造方法

            student.age=10;
            System.out.println(student);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
