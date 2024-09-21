package demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/8  8:32
 */
class ListNode {
     int val;
      ListNode next;
      ListNode() {}
    ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

class Solution {
    public ListNode middleNode(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        return slow;
    }
}
public class Test {


    public static void main(String[] args) {
        MySingleList mySingleList=new MySingleList();
        mySingleList.addFirst(1);
        mySingleList.addIndex(0,10);
        mySingleList.addIndex(0,10);
        mySingleList.addIndex(0,10);
        mySingleList.remove(10);
//        mySingleList.removeAllKey(1);
        mySingleList.display();
        System.out.println(mySingleList.contains(2));
        System.out.println(mySingleList.size());
    }
    public static MySingleList createList(){
        MySingleList mySingleList=new MySingleList();
        MySingleList.ListNode l1=new MySingleList.ListNode(1);
        MySingleList.ListNode l2=new MySingleList.ListNode(3);
        MySingleList.ListNode l3=new MySingleList.ListNode(5);
        mySingleList.head=l1;
        l1.next=l2;
        l2.next=l3;
        return mySingleList;
    }
    public static void main2(String[] args) {
//        MySingleList mySingleList=createList();
//        mySingleList.display();

        List<Integer> row1=new ArrayList<Integer>();
        List<Integer> row2=new ArrayList<Integer>();
        row1.add(1);

        System.out.println(row1);


    }
    public static void starX(int n){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
    }
    public static void main1(String[] args) {
        starX(10);
        ArrayList<Integer> arrayList=new ArrayList<>();
        arrayList.add(2);
        arrayList.add(3);
        System.out.println(arrayList);
    }
}
