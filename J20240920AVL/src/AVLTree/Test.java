package AVLTree;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/20  10:11
 */
public class Test {
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

    public static void main(String[] args) {
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
