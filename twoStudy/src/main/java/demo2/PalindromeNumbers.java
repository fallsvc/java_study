package demo2;

import java.util.Arrays;

public class PalindromeNumbers {
  // 检查一个数是否为回文数的方法
  public static boolean isPalindrome(int number) {
    // 逻辑实现
    int ret=reverse(number);// 获得反转该数

    return ret==number;// 判断是不是回文
  }
  // 反转数字
  public static int reverse(int number) {
    // 逻辑实现
    int n=number;
    int ws=0;// 位数
    while(n!=0){
      ws++;
      n/=10;
    }
    n=number;
    int sum=0;// 记录回文数大小  每位
    while(n!=0){
      int tmp=n%10;
      sum+=Math.pow(10,(ws-1))*tmp;// 反转每一位
      ws--;
      n/=10;
    }
    return sum;
  }
  
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    System.out.printf("从1到%-3d的回文数如下:\n", n);
    for (int i = 1; i < n; i++) {
      if (isPalindrome(i)) {
        System.out.print(i + " ");
      }
    }
  }
}