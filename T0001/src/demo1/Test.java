package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/19  22:14
 */
public class Test {
    //移动零     https://leetcode.cn/problems/move-zeroes/description/
    public void moveZeroes(int[] nums) {
        int dest=-1;//划分非零和零
        int cur=0;//划分已经排和未排
        while(cur<nums.length){
            if(nums[cur]!=0){
                swap(nums,dest+1,cur);
                dest++;
            }
            cur++;
        }

    }
    public void swap(int[] array,int i,int j){
        int tmp=array[i];
        array[i]=array[j];
        array[j]=tmp;
    }

    //复写零 https://leetcode.cn/problems/duplicate-zeros/
    public void duplicateZeros(int[] arr) {
        int cur=-1;
        int dest=-1;
        //找到最后需要写的位 cur
        while(dest<arr.length-1){
            cur++;
            if(arr[cur]==0){
                dest++;
            }
            dest++;
        }
        if(dest>arr.length-1){
            cur--;
            arr[--dest]=0;
            dest--;
        }

        //从后向前写
        while(cur>=0){
            //先移动一位
            arr[dest--]=arr[cur];
            //如果arr[cur]==0,还需复写一位
            if(arr[cur]==0){
                arr[dest--]=0;
            }
            cur--;
        }
    }
    //快乐树 产生循环
    //   https://leetcode.cn/problems/happy-number/submissions/566248223/
    public static boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        while(true){
            slow=getNumberSquares(slow);
            fast=getNumberSquares(fast);
            fast=getNumberSquares(fast);
            if(fast==slow) break;
        }

        return slow==1;

    }
    public static int getNumberSquares(int n){
        int sum=0;
        while(n!=0){
            int w=n%10;
            sum+=w*w;
            n/=10;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(19));
    }
}
