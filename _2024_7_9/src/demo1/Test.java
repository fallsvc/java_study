package demo1;

import java.util.LinkedList;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/9  9:01
 */
public class Test{
    public static void main(String[] args) {
        LinkedList<Integer> list=new LinkedList<>();

    }
    public static void main1(String[] args) {
        MyLinkedList myLinkedList=new MyLinkedList();

        myLinkedList.addLast(2);
        myLinkedList.addFirst(1);
        myLinkedList.addIndex(1,3);
        myLinkedList.addLast(2);
        myLinkedList.addFirst(1);
        myLinkedList.addIndex(1,3);
//        System.out.println(myLinkedList);
        myLinkedList.removeAllKey(3);
//        System.out.println(myLinkedList.contains(3));
        System.out.println(myLinkedList.size());
        myLinkedList.display();
    }

}
