package Demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/20  12:16
 */
public class Test {
    public static void main(String[] args) {
        Dog dog=new Dog();
        System.out.println(dog.age);
        dog.add();
        System.out.println(dog.age);
        dog.add(20);
        System.out.println(dog.age);
    }
}
