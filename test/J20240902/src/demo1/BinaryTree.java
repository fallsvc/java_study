package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/3  20:52
 */
public class BinaryTree<T extends Object>{
    static class Node<T>{
        T val;
        Node<T> left;
        Node<T> right;

        public Node(T val) {
            this.val = val;
        }
    }
    private Node<T> root=null;
    public void search(T t){
        Node<T> cur=root;
        while(cur!=null){
            if(cur.val.compareTo())
        }
    }
}
