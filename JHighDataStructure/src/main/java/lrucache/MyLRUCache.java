package lrucache;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/2  21:58
 */
public class MyLRUCache {

    static class DLinkNode{
        public int key;
        public int value;

        public DLinkNode prev;
        public DLinkNode next;
        public DLinkNode(){

        }
        public DLinkNode(int key,int value){
            this.key=key;
            this.value=value;
        }

        @Override
        public String toString() {
            return "[" +
                    "key=" + key +
                    ", value=" + value +
                    ']';
        }
    }

    // 带头
    public DLinkNode head;// 双向链表的头节点
    public DLinkNode tail;// 双向链表的尾节点

    public int usedSize;// 使用大小
    public Map<Integer, DLinkNode> cache;
    public int capacity; // 容量


    public MyLRUCache(int capacity){
        this.head=new DLinkNode();
        this.tail=new DLinkNode();
        head.next=tail;
        tail.prev=head;

        cache=new HashMap<>();
        this.capacity=capacity;
    }


    public int put(int key,int value){
        // 查找是否存在该元素
        DLinkNode node=cache.get(key);

        if(node==null){
            DLinkNode newNode=new DLinkNode(key,value);
            cache.put(key,newNode);// 加入cache

            addToTail(newNode);// 从后面加入元素

            usedSize++;

            if(usedSize>capacity){

                // 删除第一个
                DLinkNode del=removeFrist();

                // 从cache 中移除
                cache.remove(del.key);
                // 有效减一
                usedSize--;
            }

        }else{
            // 修改value
            node.value=value;

            // 把刚用的值移到尾部
            moveToLast(node);
        }

        return value;
    }

    private void moveToLast(DLinkNode node) {
        // 删除node
        remove(node);

        addToTail(node);// 加入尾部
    }

    private void remove(DLinkNode node) {
        DLinkNode prev=node.prev;
        prev.next=node.next;
        node.next.prev=prev;
    }

    // 删除第一个
    private DLinkNode removeFrist() {

        DLinkNode del=head.next;

        head.next=del.next;
        del.next.prev=head;

        return del;
    }

    /**
     * 添加尾部
     */

    public void addToTail(DLinkNode node){
        tail.prev.next=node;
        node.prev=tail.prev;

        node.next=tail;
        tail.prev=node;
    }

    public int get(int key){
        DLinkNode node=cache.get(key);

        if(node==null){
            return -1;
        }

        // 把使用元素移到尾
        moveToLast(node);
        return node.value;
    }

    /**
     * 遍历打印节点
     */
    public String printNodes(String str){

        StringBuilder stringBuilder=new StringBuilder();
        System.out.println(str);
        stringBuilder.append(str);

        DLinkNode cur=head.next;
        for (int i = 0; i < usedSize; i++) {
            System.out.print(cur);
            stringBuilder.append(cur.toString());
            if(i<usedSize-1){
                System.out.print(" , ");
                stringBuilder.append(" , ");
            }
            cur=cur.next;
        }
        System.out.println();

        return stringBuilder.toString();
    }



    @Override
    public String toString() {


        return "MyLRUCache{" +
                    printNodes(" ")+
                '}';
    }
}
