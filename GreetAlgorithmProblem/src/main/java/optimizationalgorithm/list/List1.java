package optimizationalgorithm.list;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/22  14:28
 */
public class List1 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public  static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "val"+val;
        }
    }
    class Solution1 {
//        https://leetcode.cn/problems/add-two-numbers/
//        两数相加
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode newHead=new ListNode();
            int sum=0;
            ListNode cur1=l1,cur2=l2,cur=newHead;
            while(cur1!=null||cur2!=null){
                // 位相加
                if(cur1!=null){
                    sum+=cur1.val;
                    cur1=cur1.next;
                }
                if(cur2!=null){
                    sum+=cur2.val;
                    cur2=cur2.next;
                }
                // 这位赋值
                cur.next=new ListNode(sum%10);
                cur=cur.next;
                // 保留进位
                sum/=10; //
            }
            if(sum!=0) cur.next=new ListNode(sum); // 只剩进位
            return newHead.next;
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution2 {
//        https://leetcode.cn/problems/swap-nodes-in-pairs/
        // 交换节点
        public ListNode swapPairs(ListNode head) {
            if(head==null||head.next==null ) return head;
            ListNode newHead=new ListNode();
            newHead.next=head;
            ListNode prev=newHead,cur=head,next=head.next;
            while(cur!=null&&next!=null){
                // 交换节点
                prev.next=next;
                cur.next=next.next;
                next.next=cur;
                // 修改指针
                prev=cur;
                cur=cur.next;
                if(cur!=null){
                    next=cur.next;
                }
            }

            return newHead.next; // 返回第二个
        }
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution3 {
//        https://leetcode.cn/problems/reorder-list/
//        重排链表
        public void reorderList(ListNode head) {
            if(head==null||head.next==null) return;
            // 1.找中间节点   **一定要注意slow的落位
            ListNode slow=head,fast=head;
            while(fast!=null&&fast.next!=null){
                slow=slow.next;
                fast=fast.next.next;
            }
            // 2.逆序后面链表
            ListNode prev=null,cur=slow.next,next=null;
            if(cur!=null) next=cur.next;
            while(next!=null){
                ListNode tmp=next.next;
                cur.next=prev;
                next.next=cur;

                prev=cur;
                cur=next;
                next=tmp;
            }
            // 3.连接两个链表
            slow.next=null;
            ListNode l1=head,l2=cur;
            ListNode newHead=new ListNode();
            ListNode c=newHead;
            // int count=0;
            while(l1!=null||l2!=null){
                if(l1!=null){
                    c.next=l1;
                    l1=l1.next;
                    c=c.next;
                }
                if(l2!=null){
                    c.next=l2;
                    l2=l2.next;
                    c=c.next;
                }

            }
            return ;
        }
    }
//    public static void main(String[] args) {
//        ListNode listNode=new ListNode(1);
//        ListNode cur=listNode;
//        cur.next=new ListNode(2);
//        cur=cur.next;
//        cur.next=new ListNode(3);
//        cur=cur.next;
//        cur.next=new ListNode(4);
//
//        Solution3.reorderList(listNode);
//        cur=listNode;
//        while(cur!=null){
//            System.out.println(cur.val);
//            cur=cur.next;
//        }
//    }
//
//    public ListNode mergeKLists(ListNode[] lists) {
//        int k=lists.length;
//
//    }
    public static void main(String[] args) {
        PriorityQueue<ListNode> priorityQueue=new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        priorityQueue.add(new ListNode(1));
        priorityQueue.add(new ListNode(2));
        System.out.println(priorityQueue.poll());
//        priorityQueue.
    }
    class Solution4 {
        public ListNode mergeKLists(ListNode[] lists) {
            if(lists==null) return null;
            int k=lists.length;

            // 小根堆
//            PriorityQueue<ListNode> priorityQueue=new PriorityQueue<>(new Comparator<ListNode>() {
//                @Override
//                public int compare(ListNode o1, ListNode o2) {
//                    return o1.val-o2.val;
//                }
//            });
            PriorityQueue<ListNode> priorityQueue=new PriorityQueue<>((o1,o2)-> o1.val-o2.val);
            for(int i=0;i<k;i++) {
                if(lists[i]!=null)
                    priorityQueue.offer(lists[i]);
            }
            ListNode newHead=new ListNode();
            ListNode cur=newHead;
            while(!priorityQueue.isEmpty()){
                ListNode l=priorityQueue.poll();
                cur.next=l;
                cur=cur.next;
                if(l.next!=null){
                    priorityQueue.offer(l.next);
                }
            }
            return newHead.next;
        }

        // 分治的方法
        public ListNode mergeKLists1(ListNode[] lists) {
            if(lists==null||lists.length==0) return null;
            return merge(lists,0,lists.length-1);
        }
        public ListNode merge(ListNode[] lists,int left,int right){
            if(left==right) return lists[left];
            int mid=(right-left)/2+left;
            ListNode l=merge(lists,left,mid);
            ListNode r=merge(lists,mid+1,right);

            // 合并
            ListNode newHead=new ListNode();
            ListNode cur=newHead;
            while(l!=null&&r!=null){
                if(l.val<r.val){
                    cur.next=l;
                    l=l.next;
                }else{
                    cur.next=r;
                    r=r.next;
                }
                cur=cur.next;
            }
            if(l!=null) cur.next=l;
            if(r!=null) cur.next=r;

            return newHead.next;
        }
    }




}
