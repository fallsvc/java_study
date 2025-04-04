package recursivesearchbacktrackin.recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2025/3/27  19:08
 */
public class Demo {
//https://leetcode.cn/problems/hanota-lcci/submissions/616201315/
    public void hanota(List<Integer> a, List<Integer> b, List<Integer> c) {
        hanota1(a,b,c,a.size());
    }
    public void hanota1(List<Integer> a, List<Integer> b, List<Integer> c,int size)  {
        if(size==0) return;
        hanota1(a,c,b,size-1);// n-1个从a通过c到b
        c.add(a.remove(a.size()-1));// 把a最上面的移动到c
        hanota1(b,a,c,size-1);// 在从b把最后的n-1个通过a移动到c
    }

//https://leetcode.cn/problems/merge-two-sorted-lists/
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        if(list1==null) return list2;
//        if(list2==null) return list1;
//
//
//        if(list1.val<list2.val) {
//            list1.next=mergeTwoLists(list1.next,list2);
//            return list1;
//        }else{
//            list2.next=mergeTwoLists(list1,list2.next);
//            return list2;
//        }
//    }
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.remove(0);
        System.out.println(list);
        Collections.reverse(list);
    }
}
