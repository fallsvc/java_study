package Demo3;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/22  23:15
 */
public class Test {
    public static void main(String[] args) {
//        Bird bird=new Bird();
//        Dog dog=new Dog();
//        Animal animal=bird;
//        animal.eat();
//        Dog d=(Dog) animal;
//        d.eat();
        Bird bird=new Bird();
        Dog dog=new Dog();
        Ac ac=bird;
        ac.doWork();
//        Dog d=(Dog) ac;
//        d.doWork();
    }
    public static void main2(String[] args) {
        Bird bird=new Bird();
        Animal animal=bird;
        animal.eat();
        Ac ac=bird;
        ac.doWork();
    }

    public static void main1(String[] args) {
        Animal animal=new Animal() {
            @Override
            public void eat() {
                System.out.println("animal eat");
            }
        };
        Ac ac=new Ac() {
            @Override
            public void doWork() {
                System.out.println("Ac do");
            }
        };
        ac.doWork();;
        animal.eat();
    }
}
