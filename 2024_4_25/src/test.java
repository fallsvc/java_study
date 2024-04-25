public class test {
    public static void main(String[] args) {
        System.out.println(11.3%2.5);
        System.out.println(12.4/2);
        long b=20;
        int a=10;
//        a=a+b;error
        a+=b;//自动类型转换
        System.out.println(a);
    float d=2.5f;
    }

    public static void main7(String[] args) {
        //数字转字符串
        int a=123456;
        String b=a+"";
        System.out.println(b);

        String c=String.valueOf(a);
        System.out.println(c);
        //字符转数字
        String c1="-12334";//不能有空格字母
        int c2=Integer.valueOf(c1);
        System.out.println(c2);
    }
    public static void main6(String[] args) {
        String a="abc";
        String b="dfg";
        int c=3;
        int d=20;
        System.out.println(c+d+"=c+d");
        System.out.println(a+b);

    }
    public static void main5(String[] args) {
        byte a=1;
        byte b=2;
//        byte c=a+b;
//        int a=10;
//        long b=20;
//        a=b;
    }
    public static void main4(String[] args) {
        //没有规定字符zhan字节大小
        boolean b;
        Boolean c=true;
        System.out.println(c);
        char a='高';
        System.out.println(a);
    }
    public static void main3(String[] args) {
        int a=1;
        int b=2;
        double c=2.2;
//        float d=1.2;
        float d=1.2F;//f
        System.out.println(1.0*a/b);
        System.out.println(d);
    }
    public static void main2(String[] args) {

        short a=10;
        System.out.println(Short.MAX_VALUE);
        byte c=20;
        System.out.println(Byte.MAX_VALUE);
    }
    public static void main1(String[] args) {
        System.out.println(10);
        int A=10;
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
//        int a=2147483648;
        long c=10L;//不建议l小写L
        System.out.println(c);
    }
}