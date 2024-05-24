package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/24  16:25
 */
public class Cat extends Animal{

    public void leap(){
        System.out.println("Cat...leap");
    }

    @Override
    public void eat() {
        super.eat();
        System.out.println("Cat .eat");
    }


}
