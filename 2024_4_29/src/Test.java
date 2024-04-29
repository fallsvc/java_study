import java.util.Arrays;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        String a="jdhsjhr";
        String b=a;
        System.out.println(b);
    }
    public static void main4(String[] args) {
        int n=1234;
        int count=0;
        while(n!=0){
            n&=(n-1);
            count++;
        }
        System.out.println(count);
    }
    public static boolean isLilyNumber(int n){
        int ws=0;
        int tmp=n;
        int sum=0;
        while(tmp!=0){
            ws++;
            tmp/=10;
        }
        tmp=n;
        while(tmp!=0){
            sum+=Math.pow(tmp%10,ws);
            tmp/=10;
        }
        if(sum!=n){
           return false;
        }
        return true;
    }
    public static void main3(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(isLilyNumber(n)){
            System.out.println("是水仙花数");
        }else{
            System.out.println("不是水仙花数");
        }
    }
    public static void main2(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i;
        for(i=2;i<Math.sqrt(n);i++) {
            if(n%i==0){
                break;
            }
        }
        if(i>Math.sqrt(n)){
            System.out.println("not prime");
        }else{
            System.out.println("is prime");
        }
    }
    public static void main1(String[] args) {
        int[] arr1={1,2,3,4,45,1,3,4};
       String arr=Arrays.toString(arr1);

        System.out.println(arr);
    }
}
