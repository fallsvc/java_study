package demo1;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/23  8:43
 */
public class Test {
    public static void main(String[] args) {

    }
    public static void main1(String[] args) {
        int[] array={9,8,7,6,5,4,3,2,1};
//        Sort.mergeSort(array);
        Sort.countSort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void main2(String[] args) {
        BinarySearchTree searchTree=new BinarySearchTree();
        searchTree.insert(5);
        searchTree.insert(3);
        searchTree.insert(4);
        searchTree.insert(7);
        searchTree.remove(3);
        searchTree.remove(5);
        System.out.println(searchTree.search(2).val);
    }
}
