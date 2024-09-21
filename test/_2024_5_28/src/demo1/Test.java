package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/28  11:46
 */
public class Test {

    public static int firstOnceAppear(String s){
        int[] count=new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if(count[s.charAt(i)-'a']==1){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s="asdfgffsa";
        System.out.println(firstOnceAppear(s));
    }

    public static void main9(String[] args) {
        StringBuilder stringBuilder=new StringBuilder("absdsnd");
        stringBuilder.reverse();
        stringBuilder.insert(4,"hhhh");
        System.out.println(stringBuilder);
    }
    public static void main8(String[] args) {
        long start =System.currentTimeMillis();
        String s="";
        for (int i = 0; i < 10000; i++) {
            s+=i;
        }
        long end=System.currentTimeMillis();
        System.out.println(end-start);

        start =System.currentTimeMillis();
        StringBuilder stringBuilder=new StringBuilder("");
        for (int i = 0; i < 10000; i++) {
            stringBuilder.append(i);
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);

        start=System.currentTimeMillis();
        StringBuffer stringBuffer=new StringBuffer("");
        for (int i = 0; i < 10000; i++) {
            stringBuffer.append(i);
        }
        end=System.currentTimeMillis();
        System.out.println(end-start);

    }
    public static void main7(String[] args) {
        StringBuilder stringBuilder=new StringBuilder();
        stringBuilder.append("hello ");
        stringBuilder.append(" world");
        System.out.println(stringBuilder.toString());

    }
    public static void main6(String[] args) {
        String s="sdc.sdf";
        char[] ret=s.toCharArray();
        for (int i = 0; i < ret.length; i++) {
            System.out.println(ret[i]);
        }

        System.out.println(s.replace('d','k'));
        String[] a=s.split("\\.");
        System.out.println(a[1]);
    }
    public static void main5(String[] args) {
        String s1 = String.valueOf(1234);
        String s2 = String.valueOf(12.34);
        String s3 = String.valueOf(true);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);

        int data1 = Integer.parseInt("1234");
        double data2 = Double.parseDouble("12.34");
        int data3 = Integer.valueOf("1234");
        double data4 = Double.valueOf("12.34");
        System.out.println(data1+1);
        System.out.println(data2);
        System.out.println(data3+1);
        System.out.println(data4);

    }
    public static void main4(String[] args) {
        String string1=new String("aef");
        String string2=new String("aeF");

        System.out.println(string1.lastIndexOf("e", 2));

        for (int i = 0; i < string1.length(); i++) {
            System.out.println(string1.charAt(i));
        }
//        System.out.println(string1.equalsIgnoreCase(string2));
//        System.out.println(string1.compareTo(string2));
//
//        System.out.println(string1.compareToIgnoreCase(string2));



    }
    public static void mai3(String[] args) {
        String string="hello";
        String string2=new String("world");
//        byte[] value=;//jdk17
        String string3=new String(new byte[]{'a','b','c'});
        System.out.println(string);
        System.out.println(string2);
        System.out.println(string3);
    }
    public static boolean isAdmin(String userId){
        return userId.toLowerCase()=="admin";
    }
    public static void main2(String[] args){
        String s1="abc"+"def";//1
        String s2=new String(s1);//2
        if(s1.equals(s2))//3
            System.out.println(".equals succeeded");//4
        if(s1==s2)//5
            System.out.println("==succeeded");//6
        System.out.println(isAdmin("Admin"));
    }

    public static void main1(String[] args) {
        String a=" ";
        Character.isDigit('a');
        Character.isLetter('a');
    }
}
