package btree;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/3  17:27
 */
public class demo1 {
    public static void main(String[] args) {
        MyBTree myBTree=new MyBTree();

        int[] array={53, 139, 75, 49, 145, 36, 101};
        for (int i = 0; i < array.length; i++) {
            myBTree.insert(array[i]);
        }

        myBTree.inOrder(myBTree.root);
    }
}
