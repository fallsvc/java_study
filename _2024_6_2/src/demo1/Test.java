package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/2  21:14
 */
public class Test {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();//当前时间ms
        String s=" ";
        for (int i = 0; i < 10000; i++) {
            s+=i;
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);

        start =System.currentTimeMillis();
        StringBuffer stringBuffer=new StringBuffer("");
        for (int i = 0; i < 10000; i++) {
            stringBuffer.append(i);
        }
        end =System.currentTimeMillis();
        System.out.println(end-start);

        StringBuilder stringBuilder=new StringBuilder("");
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append(i);
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);

    }
    public static void main9(String[] args) {
        String s="  hello  world  ";
        System.out.println(s.trim());//hello  world
    }
    public static void main8(String[] args) {
        String s="helloworld";
        System.out.println(s.substring(5));//world
        System.out.println(s.substring(1,3));//el
    }
    public static void main7(String[] args) {
        //多次拆分
        String s="name=age&nnin=g";
        String[] s1=s.split("&");
        for (String x: s1) {
            String[] s2=x.split("=");
            for (String y:s2) {
                System.out.println(y);
            }
        }

    }
    public static void main6(String[] args) {
        String str = "hello world hello bit" ;
        String[] result1=str.split(" ");//以空格拆分
        for(String s: result1) {
            System.out.println(s);
        }
        System.out.println("================");
        String[] result2 = str.split(" ",2);//限制拆分成两个字符串
        for(String s: result2) {
            System.out.println(s);
        }
        //1. 字符"|","*","+"，"."都得加上转义字符，前面加上 "\\" .
        // 2. 而如果是 "\" ，那么就得写成 "\\\\" .
        // 3. 如果一个字符串中有多个分隔符，可以用"|"作为连字符.
        str = "192.168.2.1" ;
        String[] result = str.split("\\.") ;
        for(String s: result) {
            System.out.println(s);
        }
    }

    public static void main5(String[] args) {
        String str = "helloworld" ;
        //替换所有l
        System.out.println(str.replaceAll("l", "_"));
       //替换第一个l
        System.out.println(str.replaceFirst("l", "_"));
    }
    public static void main4(String[] args) {
        String s=String.format("%d-%d",10,10);
        System.out.println(s);//10-10
    }

    public static void main3(String[] args) {
        String s="hello";
        //字符串转数组
        char[] ch=s.toCharArray();
        //数组到字符串
        String s1=new String(ch);
    }
    public static void main2(String[] args) {
        String s1="asadf";
        String s2="ASD..=a";
        //to大写
        System.out.println(s1.toUpperCase());//ASADF
        //小写
        System.out.println(s2.toLowerCase());//asd..a
    }
    public static void main1(String[] args) {
        String s1=String.valueOf(123);
        String s2=String.valueOf(true);
        String s3=String.valueOf(new Object());//调用toString()

        //parse 针对字符串
        int data1=Integer.parseInt("1234");
        double data2=Double.parseDouble("1.11");
    }
}
