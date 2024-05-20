package Demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/18  11:21
 */
public abstract class Animal {
    private int a;
    public String name;

    public Animal(int a, String name) {
        this.a = a;
        this.name = name;
    }

    public abstract void eat();

}
