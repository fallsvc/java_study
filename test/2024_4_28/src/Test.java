import java.util.Arrays;
import java.util.Scanner;

public class Test {

    //汉诺塔
    public static void move(char pos1,char pos2){
        System.out.print(pos1+"->"+pos2+" ");
    }
    public static void hanoi(int n,char pos1,char pos2,char pos3){

        if(n==1){
            move(pos1,pos3);
        }else{
            hanoi(n-1,pos1,pos3,pos2);
            move(pos1,pos3);
            hanoi(n-1,pos2,pos1,pos3);
        }
    }
    public static void main(String[] args) {
//        move('a','b');
        hanoi(2,'A','B','C');
        System.out.println();
        hanoi(3,'A','B','C');
        System.out.println();
        hanoi(4,'A','B','C');

    }
    public static double max(double x,double y,double z){
        double a=x>y?x:y;//先求一个比较大的值
        return a>z?a:z;
    }
    public static int max(int x,int y){
        return x>y?x:y;
    }
    public static void main6(String[] args) {
        int a=10;
        int b=20;
        double a1=10.5;
        double b1=12.0;
        double c1=0.5;
        System.out.println(max(a,b));
        System.out.println(max(a1,b1,c1));
    }
    //求和
    public static double add(double x,double y,double z){
        return x+y+z;
    }
    public static int add(int x,int y){
        return x+y;
    }
    public static void main5(String[] args) {
        int a=10;
        int b=20;
        double a1=10.5;
        double b1=12.0;
        double c1=0.5;
        System.out.println(add(a,b));
        System.out.println(add(a1,b1,c1));
    }
    //比较大小
    public static int max3(int x,int y,int z){
        int ret=max2(x,y);
        return ret>z?ret:z;
    }
    public static int max2(int x,int y){
        return x>y?x:y;
    }
    public static void main4(String[] args) {
        int a=10;
        int b=20;
        int c=30;
        int ret=max3(a,b,c);
        System.out.println(ret);
    }
    //一个数二进制有多少个1
    public static void main3(String[] args) {
//        int n=10;
//        n*=2+3;//先计算等号右边值
//        System.out.println(n);
        int[] arr={1,2,3,4,5,6};
        String s=Arrays.toString(arr);
        System.out.println(s);
    }
    public static void main2(String[] args) {
        int n=123;
        int count=0;
        while(n!=0){
            n&=(n-1);
            count++;
        }
        System.out.println(count);
    }
    public static void main1(String[] args) {
        Scanner sc=new Scanner(System.in);

        while(sc.hasNextInt()){
            int n=sc.nextInt();
            System.out.println(n);
        }
    }
}
