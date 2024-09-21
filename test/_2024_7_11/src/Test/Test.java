package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/11  16:10
 */
public class Test {
    public static List<List<Integer>> generate(int n){
        if(n<0){
            return null;
        }
        List<List<Integer>> ret=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list=new ArrayList<>();
            for (int j = 0; j <=i ; j++) {
               if(i==j||j==0){
                   list.add(1);
               }else{
                   int val=ret.get(i-1).get(j-1)+ret.get(i-1).get(j);
                   list.add(val);
               }
            }
            ret.add(list);
        }
        return ret;
    }
    static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public static ListNode removeElements(ListNode head, int val) {
        ListNode cur = head;
        ListNode prev = null; // 标记cur的前一个
       while(cur!=null){
           if(cur.val==val){
               if(prev==null){
                   head=head.next;
               }else {
                   prev.next=cur.next;
               }
           }else{
               prev=cur;
           }
           cur=cur.next;
       }
       return head;
    }
    public static ListNode reverseList(ListNode head) {

        return null;
    }

    public static void display(ListNode head){
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        List<List<Integer>> ret=generate(5);
//        for (int i = 0; i < ret.size(); i++) {
//            System.out.println(ret.get(i));
//            System.out.println(ret.get(i));
//        }
        ListNode l1=new ListNode(1);
        ListNode l2=new ListNode(2);
        ListNode l3=new ListNode(3);
        ListNode l4=new ListNode(2);
        l1.next=l2;
        l2.next=l3;
        l3.next=l4;

        display(l1);
        removeElements(l1,2);
        display(l1);
    }
}

