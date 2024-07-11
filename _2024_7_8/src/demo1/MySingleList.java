package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/8  9:26
 */
public class MySingleList implements IList{
    public ListNode head;
    static class ListNode{
        public int val;
        public ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }
    //头插法
    public void addFirst(int data){

        ListNode node=new ListNode(data);

        node.next=head;
        head=node;

    }//尾插法
    public void addLast(int data){
        //创建新节点
        ListNode node=new ListNode(data);
//        node.next=null;//类内默认null值
        //判断链表是否为空
        if(head==null){
            head=node;
            return;
        }
        //遍历链表找到next为空的节点，让它的next引用新节点1
        ListNode cur=head;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=node;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        if(index<0||index>size()){
            throw new CheckIndex("index不合法");
        }
        if(index==0){
            addFirst(data);
            return;
        }
        ListNode node=new ListNode(data);

        ListNode cur=head;
        int i=0;
        while(i++<index-1){
            cur=cur.next;//拿到index位置前一个
        }
        node.next=cur.next;
        cur.next=node;
    }
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    }//删除第一次出现关键字为key的节点
    public void remove(int key){
        if(head==null){
            return ;
        }
        if(head.val==key){
            head=head.next;
            return;
        }
        ListNode cur=head;
        while(cur.next!=null){
            if(cur.next.val==key){
                break;
            }
            cur=cur.next;
        }
        cur.next=cur.next.next;
    }
    //删除所有值为key的节点
    public void removeAllKey(int key){
        if(head==null){
            return;
        }
        ListNode prev=head;
        ListNode cur=head.next;
        while(cur!=null){

            if(cur.val==key){
                prev.next=cur.next;
                cur=cur.next;
            }else{
                prev=cur;
                cur=cur.next;
            }
        }
        if(head.val==key){
            head=head.next;
        }
    }
    //得到单链表的长度
    public int size(){
        int len=0;
        ListNode cur=head;
        while(cur!=null){
            len++;
            cur=cur.next;
        }

        return len;
    };
    public void clear(){
        //暴力释放
//       head=null;
        ListNode cur=head;
        //温柔释放
        while(cur!=null){
            ListNode curN=cur.next;
            cur.next=null;
            cur=curN;
        }
        head=null;
    }

    public void display() {
        ListNode cur=head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    };
public static void display(ListNode h) {
        ListNode cur=h;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur=cur.next;
        }
        System.out.println();
    };

}
