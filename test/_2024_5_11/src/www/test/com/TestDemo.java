package www.test.com;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/11  20:32
 */
public class TestDemo {
    public TestDemo() {
    }//也会默认age=0;
    //name=null;

    public TestDemo(int age, String name) {
        this.age = age;
        this.name = name;
    }

    int age;//default
    private String name;
    public void setAge(int age){
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void showName(){
        System.out.println(name);
    }
}
