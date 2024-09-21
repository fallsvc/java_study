package AVLTree;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/20  10:11
 */
public class Test {
    public static void main(String[] args) {
        MyAVLTree myAvlTree =new MyAVLTree();
//        int[] arr={16, 3, 7, 11, 9, 26, 18, 14, 15};

        int[] arr={4, 2, 6, 1, 3, 5, 15, 7, 16,14};
        for (int i = 0; i < arr.length; i++) {
            myAvlTree.insert(arr[i]);
        }

        System.out.println(myAvlTree.isBalance(myAvlTree.root));
    }
    //求数的算术平方根
    public static int sqrt (int x) {
        if(x<2) return 1;
        // write code here
        int left=1;
        int right=x/2;
        while(left<right){
            int mid=(right-left+1)/2+left;//加1不可省保证了后面right值可取
            int val=x/mid;
           if(val<mid){
               right=mid-1;
           }else{
               left=mid;
           }
        }
        return left;
    }

    public static void main2(String[] args) {
        System.out.println(sqrt(16));
    }
    public static void main1(String[] args) {
        Float a=1.0F;
        // '\0'表示空格
        String s = "hello,world\0aa";
        System.out.println(a);
        System.out.println(s);
    }
}
