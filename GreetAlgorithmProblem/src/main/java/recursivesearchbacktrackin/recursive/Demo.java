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

//    https://leetcode.cn/problems/reverse-linked-list/submissions/616622975/
//    public ListNode reverseList(ListNode head) {
//        if(head==null ||head.next==null) return head;
//
//        ListNode ret=reverseList(head.next);// 反转后面的并返回头指针
//        // 连接这个点
//        head.next.next=head;
//        head.next=null;
//
//        return ret;
//    }

//
//    https://leetcode.cn/problems/swap-nodes-in-pairs/submissions/616627547/
//    public ListNode swapPairs(ListNode head) {
//        if(head==null ||head.next==null) return head;
//        ListNode ret=swapPairs(head.next.next);// 先交换两个节点后面的 返回头节点
//        // 交换当前并与后面连接
//        ListNode tmp=head.next;
//        head.next.next=head;
//        head.next=ret;
//
//        return tmp; // 返回第二个
//    }

//    https://leetcode.cn/problems/powx-n/
    public double myPow(double x, int n) {
        return n<0?1.0/pow(x,-n):pow(x,n);
    }
    public double pow(double x,int n){
        if(n==0) return 1.0;
        double tmp=pow(x,n/2);
        return n%2==0?(tmp*tmp):(tmp*tmp*x);
    }
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
