package demo2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/8/4  21:26
 */
public class Duck implements IFlying,IRunning,ISwimming{
    @Override
    public void fly() {
        System.out.println("Duck...fly");
    }

    @Override
    public void run() {
        System.out.println("Duck....run");
    }

    @Override
    public void swim() {
        System.out.println("Duck....swim");
    }
}
