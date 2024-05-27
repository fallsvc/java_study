package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/27  19:24
 */
public class Test {
    public static void main(String[] args) {
        String s=" ajdds dfs  ";
        System.out.println(s.trim());
        System.out.println(s.substring(2, 5));

    }
    public static void main2(String[] args) {
        String s=new String("h=e.l+o");
        String p="hellO";
        String[] q=s.split("=|\\.");
        for (int i = 0; i < q.length; i++) {
            System.out.println(q[i]);
        }
        s=s.replace("l","h");
        System.out.println(s);
        String str = "helloworld" ;
        System.out.println(str.replaceAll("l", "_"));
        System.out.println(str.replaceFirst("l", "_"));
    }
    public static void main1(String[] args) {

        System.out.println();
        String s=new String("hello");
        String p="hellO";
        System.out.println(s.charAt(2));
        System.out.println(s.indexOf("ll", 2));
        System.out.println(s.lastIndexOf("ll"));

        System.out.println(s.compareTo(p));
        System.out.println(s.compareToIgnoreCase(p));
        System.out.println(String.format("%d-%s",20,"dfrd"));
    }
}
