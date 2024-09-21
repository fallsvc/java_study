package demo2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/27  22:41
 */
public class Solu {
    static class Node{
        public int val;
        public Node next;
        public Node random;
        public Node(int val){
            this.val=val;
        }
    }
    //复制深拷贝链表 ，链表含有random 随机引用
    public Node copyRandomList(Node head){
        if(head==null) return null;

        //map映射 原链表和新链表节点一一对应 先拷贝val
        Map<Node,Node> map=new HashMap<>();
        Node cur=head;
        while(cur!=null){
            Node newNode=new Node(cur.val);
            map.put(cur,newNode);
            cur=cur.next;
        }
        //重新遍历 根据映射关系连接新链表
        cur=head;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }

        return map.get(head);
    }
    public int singleNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(Integer x:nums){
            if(set.contains(x)){
                set.remove(x);
            }else{
                set.add(x);
            }


        }

        for(Integer x:nums){
            if(set.contains(x)){
                return x;
            }
        }

        return -1;
    }
}
