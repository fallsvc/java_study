package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/13  8:40
 */
public class MyQueue {

    static class ListNode {
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode first = null;
    public ListNode last = null;

    public int usedSize = 0;

    public void offer(int val) {
        ListNode node=new ListNode(val);

        if(isEmpty()){
            first=last=node;
        }else{
            last.next=node;
            node.prev=last;
            last=last.next;
        }
        usedSize++;
    }

    public int poll() {
        if(isEmpty()){
            return -1;
        }
        int retVal= first.val;
        first=first.next;
        if(!isEmpty()){
            first.prev=null;
        }
        usedSize--;
        return retVal;
    }

    public int peek() {
        if(isEmpty()){
            return -1;
        }

        return first.val;
    }

    public boolean isEmpty() {

        return first==null;
    }

}