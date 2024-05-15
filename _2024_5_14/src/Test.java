/**
 * @auther falls_vc
 * description:
 * @date 2024/5/14  11:43
 */
public class Test {


    public static int[][] doubleDArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j]=i+j;
            }
        }
        return array;
    }

    public static void printD(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j]+"  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] array=new int[10][10];
        int[][] ret=doubleDArray(array);
        printD(array);
        System.out.println("===========");
        printD(ret);
    }
    public static void main3(String[] args) {
//        System.out.println(TestDemo.getZ());
//        TestDemo.z=100;
//        System.out.println(TestDemo.z);

        TestDemo t=new TestDemo();
        System.out.println(t);

        System.out.println(t.toString());
        System.out.println(t.add());

    }
    public String toString() {
        System.out.print("aaa");
        return "bbb";
    }

    public static void main2(String[] args) {
        Test test = new Test();
        System.out.println(test);
    }
    static int cnt = 6;
    static{
        cnt += 9;
    }
    public static void main1(String[] args){
        System.out.println("cnt = " + cnt);
    }
    static{
        cnt /=3;
    };
}
