package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/9  15:05
 */
public class MyLinkedList implements IList{
    static class ListNode{
        public int val;
        public ListNode prev;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode head;
    public ListNode last;
    @Override
    public void addFirst(int data) {
        ListNode node=new ListNode(data);
        if(head==null){
            head=last=node;
        }else {
            head.prev=node;
            node.next=head;
            head=node;
        }

    }

    @Override
    public void addLast(int data) {
        ListNode node=new ListNode(data);
        if(last==null){
            head=last=node;
        }else{
            last.next=node;
            node.prev=last;
            last=node;
        }
    }

    @Override
    public void addIndex(int index, int data) {
        int len=size();
        if(index<0||index>len){
            return;
        }
        if(index==0){
            addFirst(data);
            return ;
        }
        if(index==len){
            addLast(data);
            return;
        }
        ListNode node=new ListNode(data);
        ListNode ret=findByIndex(index);
        node.next=ret;
        node.prev=ret.prev;
        //下面两个不能交换顺序
        ret.prev.next=node;
        ret.prev=node;


//        ListNode prev=head;
//        while(index-->1){
//            prev=prev.next;
//        }
//        node.prev=prev;
//        node.next=prev.next;
//        prev.next=node;
    }
    public ListNode findByIndex(int index){
        ListNode ret=head;
        while(index>0){
            ret=ret.next;
            index--;
        }

        return ret;
    }

    @Override
    public boolean contains(int key) {
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }

    @Override
    public void remove(int key) {
        if(head==null){
            return;
        }
        if(head.val==key){
            head=head.next;
            head.prev=null;
            return;
        }

        ListNode cur=head.next;
        while(cur!=last){
            if(cur.val==key){
                cur.prev.next=cur.next;
                cur.next.prev=cur.prev;
                break;
            }
            cur=cur.next;
        }
        if(cur==last){
            if(last.val==key){
                last=last.prev;
                last.next=null;
            }
        }
    }

    @Override
    public void removeAllKey(int key) {

        if(head==null){
            return;
        }

        ListNode cur=head;
        while(cur!=null){
            if(cur.val==key){
                if(cur==head){
                    head=head.next;
                    head.prev=null;
                }else{
                    cur.prev.next=cur.next;
                    if(cur!=last){
                        cur.next.prev=cur.prev;
                    }else{
                        last=cur.prev;
                    }
                }

            }

            cur=cur.next;
        }

    }

    @Override
    public int size() {
       ListNode cur=head;
       int count=0;
       while(cur!=null){
           cur=cur.next;
           count++;
       }

       return count;
    }

    @Override
    public void clear() {
        ListNode cur=head;
        while(cur!=null){
            ListNode curN=cur.next;
            cur.next=null;
            cur.prev=null;
            cur=curN;
        }
        head=null;
        last=null;
    }

    @Override
    public void display() {
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }

        System.out.println();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder=new StringBuilder("");
        ListNode cur=head;
        while(cur!=null){
            stringBuilder.append(cur.val+" ");
            cur=cur.next;
        }

        return "MyLinkedList{ " +stringBuilder
                 +
                '}';
    }
}
