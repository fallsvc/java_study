package dynamicprogramming.knapsackproblem;

import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/23  14:15
 */
public class Demo01 {

    public class Main1 {
//        https://www.nowcoder.com/practice/fd55637d3f24484e96dad9e992d3f62e?tpId=230&tqId=2032484&ru=/exam/oj&qru=/ta/dynamic-programming/question-ranking&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196
//       背包问题01
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextInt()) { // 注意 while 处理多个 case
                int n = in.nextInt();
                int v = in.nextInt();
                int[] vs=new int[n];
                int[] values=new int[n];
                for(int i=0;i<n;i++){
                    vs[i]=in.nextInt();
                    values[i]=in.nextInt();
                }
                kp(n,v,vs,values);
            }
        }
        public static void kp(int n,int v,int[] vs,int[] values){
            int[][] dp1=new int[1+n][1+v];// 最大
            int[][] dp2=new int[1+n][1+v];// 容量恰好
            // 初始化 -1表示dp2[i][j] 前i个元素不能达到容量为 j
            for(int i=1;i<=v;i++){
                dp2[0][i]=-1;
            }

            for(int i=1;i<=n;i++){
                for(int j=1;j<=v;j++){
                    if(j-vs[i-1]>=0){
                        dp1[i][j]=Math.max(dp1[i-1][j-vs[i-1]]+values[i-1],dp1[i-1][j]);
                    }else{
                        dp1[i][j]=dp1[i-1][j];
                    }
                    if(j-vs[i-1]>=0&&dp2[i-1][j-vs[i-1]]!=-1){
                        dp2[i][j]=Math.max(dp2[i-1][j-vs[i-1]]+values[i-1],dp2[i-1][j]);
                    }else{
                        dp2[i][j]=dp2[i-1][j];
                    }
                }
            }
            System.out.println(dp1[n][v]);
            System.out.println(dp2[n][v]==-1?0:dp2[n][v]);
        }
    }
    /// 空间优化  滚动数组
    public class Main2{
//
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            // 注意 hasNext 和 hasNextLine 的区别
            while (in.hasNextInt()) { // 注意 while 处理多个 case
                int n = in.nextInt();
                int v = in.nextInt();
                int[] vs=new int[n];
                int[] values=new int[n];
                for(int i=0;i<n;i++){
                    vs[i]=in.nextInt();
                    values[i]=in.nextInt();
                }
                kp(n,v,vs,values);
            }
        }
        public static void kp(int n,int v,int[] vs,int[] values){
            // 空间优化  滚动数组   使用一个一维数组 从左到右进行填表
            int[] dp1=new int[1+v];// 最大
            int[] dp2=new int[1+v];// 容量恰好
            // 初始化 -1表示dp2[i][j] 前i个元素不能达到容量为 j
            for(int i=1;i<=v;i++){
                dp2[i]=-1;
            }

            for(int i=1;i<=n;i++){
                for(int j=v;j>=vs[i-1];j--){// 隐藏了 dp1[j]=dp1[j]去掉一个维度

                    dp1[j]=Math.max(dp1[j-vs[i-1]]+values[i-1],dp1[j]);

                    if(dp2[j-vs[i-1]]!=-1){
                        dp2[j]=Math.max(dp2[j-vs[i-1]]+values[i-1],dp2[j]);
                    }
                }
            }
            System.out.println(dp1[v]);
            System.out.println(dp2[v]==-1?0:dp2[v]);
        }
    }
}
