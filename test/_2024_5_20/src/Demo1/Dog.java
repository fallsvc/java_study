package Demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/20  12:23
 */
public class Dog extends Animal{
    @Override
    public int add() {
        return super.add();
    }

    public int add(int x){
        age+=x;
        return age;
    }
}
