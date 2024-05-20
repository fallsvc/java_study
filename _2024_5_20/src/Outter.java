/**
 * @auther falls_vc
 * description:
 * @date 2024/5/20  22:11
 */
public class Outter {
    public int data1;
    public int data2;
    class Inner{
        public int data2;
        // 在实例内部类中可以直接访问外部类中：任意访问限定符修饰的成员
        void print(){
            System.out.println(data1);
        }
        // 如果外部类和实例内部类中具有相同名称成员时，优先访问的是内部类自己的
        void print2(){
            System.out.println(data2);
        }
        // 如果要访问外部类同名成员时候，必须：外部类名称.this.同名成员名字
        void print1(){
            System.out.println(Outter.this.data2);
        }
    }

    public static void main(String[] args) {
        // 外部类：对象创建 以及 成员访问
        Outter out = new Outter();
        // 创建实例内部类对象
        Outter.Inner innerClass1 = new Outter().new Inner();

        // 上述语法比较怪异，也可以先将外部类对象先创建出来，然后再创建实例内部类对象
        Outter.Inner innerClass2 = out.new Inner();
    }
}
