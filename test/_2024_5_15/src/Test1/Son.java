package Test1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/15  10:39
 */
public class Son extends Fa{
    public int z;

    static{
        System.out.println("static son");
    }
    {
        System.out.println("sl   son");
    }
    public Son(){
        super();
    }

    public Son(String name, int age, int z) {
        super(name, age);
        this.z = z;
        System.out.println("son gz...");
    }

    public void speak(){
        System.out.println("cfcf   ....");
    }
    public void status(){
        System.out.println("上学 。。。 ");
    }

}
