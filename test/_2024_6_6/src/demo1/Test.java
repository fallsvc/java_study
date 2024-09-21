package demo1;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/6  20:38
 */
public class Test {
    //洗牌
    public static void main(String[] args) {
        //1.买52张牌
        CardDemo c=new CardDemo();
        List<Card> s=c.buyCard();
        //2.洗牌
        c.shuffle(s);
        //3.3个人每人轮流揭开5张牌

        List<List<Card>> ret=c.play(s);
        //拿的牌
        for (List<Card> x :
                ret) {
            System.out.println(x);
        }

       //剩下的牌
        System.out.println(s);
    }
    //杨辉三角
    public static ArrayList<ArrayList<Integer>> yHui(int nSize){
        if(nSize<=0){
            return null;
        }
        ArrayList<ArrayList<Integer>> ret=new ArrayList<>();
        //第一行
        ArrayList<Integer> list0=new ArrayList<>();
        list0.add(1);
        ret.add(list0);

        for (int i = 1; i < nSize; i++) {
            ArrayList<Integer> curRow=new ArrayList<>();
            curRow.add(1);//第一个元素
            ArrayList<Integer> upRow=ret.get(i-1);
            for (int j = 1; j < i; j++) {
                int p=upRow.get(j);
                int n=upRow.get(j-1);
                curRow.add(p+n);
            }
            //最后一个元素
            curRow.add(1);

            ret.add(curRow);
        }
        return ret;
    }
    public static void main5(String[] args) {
        ArrayList<ArrayList<Integer>> s=yHui(5);
        for (int i = 0; i < s.size(); i++) {
            System.out.println(s.get(i));
        }
    }
    public static void main4(String[] args) {
        ArrayList<Integer> l1=new ArrayList<>();
        l1.add(11);
        l1.add(12);
        ArrayList<Integer> l2=new ArrayList<>();
        l2.add(11);
        l2.add(12);
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        list.add(l1);
        list.add(l2);
        System.out.println(list);
    }
    public static void main3(String[] args) {
        String str1="welcome to china";
        String str2="come";
        ArrayList<Character> s=new ArrayList<>();

        for (int i = 0; i < str1.length(); i++) {
            char ch=str1.charAt(i);
            if(!str2.contains(ch+"")){
                s.add(ch);
            }
        }

        for (char x :
                s) {
            System.out.print(x);
        }
        System.out.println();
        StringBuilder stringBuilder=new StringBuilder("");
        for (int i = 0; i < str1.length(); i++) {
            char ch=str1.charAt(i);
            if(!str2.contains(ch+"")){
                stringBuilder.append(ch);
            }
        }
        System.out.println(stringBuilder.toString());

    }
    public static void main2(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(12);
        list.add(11);
        list.add(10);
        System.out.println(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        for (Integer x :
                list) {
            System.out.print(x+" ");
        }
        System.out.println();

        Iterator<Integer> t=list.iterator();

        while(t.hasNext()){
            System.out.print(t.next()+" ");
        }
        System.out.println();

        ListIterator<Integer> r=list.listIterator();
        while(r.hasNext()){
            System.out.print(r.next()+" ");
        }
        System.out.println();

        ListIterator<Integer> r1=list.listIterator(3);//不包含2
        while(r1.hasPrevious()){
            System.out.print(r1.previous()+" ");
        }
        System.out.println();
    }
    public static void main1(String[] args) {
        ArrayList<Integer> list=new ArrayList<>();
        list.add(12);
        list.add(11);
        list.add(10);
        System.out.println(list);
        ArrayList<Integer> list2=new ArrayList<>(list);
        list2.addAll(list);
        System.out.println(list2);
    }
}
