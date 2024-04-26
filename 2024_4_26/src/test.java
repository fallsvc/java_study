import java.util.Scanner;

public class test {
    //辗转相除法、
    public static void main(String[] args) {
        int a=15;
        int b=20;
        int r=a%b;
        while(r!=0) {
            a=b;
            b=r;
            r=a%b;
        }
        System.out.println(b);
    }
    //求一个整数，在内存当中存储时，二进制1的个数。
    public static void main14(String[] args) {
        int n=-1;
        int count=0;
        for(int i=0;i<32;i++) {
            if((n&(1<<i))!=0){
                count++;
            }
        }
        System.out.println(count);
    }
//计算1/1-1/2+1/3-1/4+1/5 …… + 1/99 - 1/100 的值    。
    public static void main13(String[] args) {
        double i=1.0;
        double sum=0;
        for(i=1.0;i<=100.0;i++)
        {
            sum+=1.0/i;
        }
        System.out.println(sum);
    }
    //求出0～n之间的所有“水仙花数”并输出。(“水仙花数”是指一个三位数
    // ，其各位数字的立方和确好等于该数本 身，如；153＝1^3＋5^3＋3^3，则153是一个“水仙花数“。）
    public static void main12(String[] args) {
        int n=1000;
        int tmp=0;

        for(int i=0;i<n;i++) {
            int sum=0;
            tmp=i;
            int ws=0;//计算位数
            while(tmp!=0){
                ws++;
                tmp/=10;
            }
            //计算n次方和
            tmp=i;
            while(tmp!=0){
                //计算每个数的n次方
                int j=ws;
                int jc=1;
                while(j!=0){
                    j--;
                    jc*=tmp%10;
                }
                sum+=jc;
                tmp/=10;
            }

            if(i==sum){
                System.out.println(i);
            }
        }
    }
    public static void main11(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(j==i||j+i==n-1){
                        System.out.print("* ");
                    }else{
                        System.out.print("  ");
                    }
                }
                System.out.println();
            }

        }
//        int n = in.nextInt();
//        int i=0;
//        int j=0;
//        for(i=0;i<n;i++) {
//            for(j=0;j<n;j++){
//                if(j==i||j+i==n-1){
//                    System.out.println("* "+"");
//                }else{
//                    System.out.println("  "+"");
//                }
//
//            }
//        System.out.println();
    }
    //给定一个数字，判定一个数字是否是素数
    public static void main10(String[] args) {
        int n=123;
        int flag=0;
        int i=0;
        for(i=2;i<flag/2;i++) {
            if(n%2==0){
                flag=1;
            }
        }
        if(flag==1){
            System.out.println("不是素数");
        }else{
            System.out.println("是素数");
        }
    }
    //编写程序数一下 1到 100 的所有整数中出现多少个数字9
    public static void main9(String[] args) {
        int i=1;
        int n=0;
        int count=0;
        while(i<100) {
            n=i;
            while(n!=0){
                if(n%10==9){
                    count++;
                }
                n/=10;
            }
            i++;
        }
        System.out.println(count);
    }
    public static void main8(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入你的姓名：");
//        String name = sc.nextLine();
//        System.out.println("请输入你的年龄：");
//        int age = sc.nextInt();
//        System.out.println("请输入你的工资：");
//        float salary = sc.nextFloat();
//        System.out.println("你的信息如下：");
//        System.out.println("姓名: "+name+"\n"+"年龄："+age+"\n"+"工资："+salary);
//        sc.close(); // 注意, 要记得调用关闭方法
        Scanner sc= new Scanner(System.in);
        //不能先输数字再输字符串
//        String b=sc.nextLine();
//        System.out.println(b);
//
//        int a=sc.nextInt();
//        System.out.println(a);
        int n= sc.nextInt();
        String b=sc.nextLine();//可能有\n
            System.out.println(b);
            sc.close();
    }
    public static void main7(String[] args) {
        int i=1;
        while(i<=100){
            if(i%15!=0)
            {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }

    }
    public static void main6(String[] args) {
//        int i=1;
//        for(i=1;i<10;i++){
//            if(i==3){
//                continue;
//            }
//            System.out.println(i);
//        }
//        for(int i=1;i<10;i++){
//            System.out.println(i);
//        }

        int i=1;
        while(i<10)
        {
            if(i==3)
            {
                i++;
                continue;
            }
            System.out.println(i);
            i++;
        }
    }
    public static void main5(String[] args) {
        int i=1;
        int ret=1;
        int n=5;
        int sum=0;
        while(i<=n){
            ret*=i;
            sum+=ret;
            i++;
        }
        System.out.println("5!+4!+3!...="+sum);
    }

    public static void main4(String[] args) {
        int x = 10;
        int y = 10;
        if (x == 10){
            if (y == 11){
                System.out.println("aaa");}
        }
            else {
            System.out.println("bbb");
        }
    }

    public static void main3(String[] args) {
        int a=10>20?10:20;
        System.out.println(a);
//        10>20?10:20;
    }
    public static void main2(String[] args) {
//        System.out.println(!false);
//        System.out.println(!true);
        System.out.println(1^3);//
        byte a=-1;//整型提升
        a>>>=1;
        System.out.println(a);
        System.out.println(~-1);
    }
    public static void main1(String[] args) {
//        System.out.println(12);
        int a = 10;
        int b = 20;
        // 注意：在Java中 = 表示赋值，要与数学中的含义区分
////      在Java中 == 表示相等
//        System.out.println(a == b);       // false
//        System.out.println(a != b);       // true
//        System.out.println(a < b);        // true
//        System.out.println(a > b);        // false
//        System.out.println(a <= b);       // true
//        System.out.println(a >= b);       // false
        System.out.println(a!=0&&b!=0);
        //不能数字直接//while(10);
//        while(true);
    }
}
