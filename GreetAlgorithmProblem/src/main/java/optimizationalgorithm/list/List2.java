package optimizationalgorithm.list;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/23  17:44
 */
public class List2 {
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
//        https://leetcode.cn/problems/reverse-nodes-in-k-group/
//        k个元素逆序
        public ListNode reverseKGroup(ListNode head, int k) {
            ListNode cur=head;
            int n=0;// 计算有多少个节点
            while(cur!=null){
                cur=cur.next;
                n++;
            }

            int zs=n/k;// 组数
            cur=head;

            ListNode newHead=new ListNode();
            ListNode c=newHead;
            for(int i=0;i<zs;i++){
                ListNode tmp=cur;
                for(int j=0;j<k;j++){
                    // 头插
                    ListNode next=cur.next;
                    cur.next=c.next;
                    c.next=cur;

                    cur=next;
                }
                c=tmp;// 尾节点当头节点
            }
            c.next=cur;

            return newHead.next;
        }
    }
}
