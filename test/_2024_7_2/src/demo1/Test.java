package demo1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/2  23:17
 */
public class Test {
    //合并数组
    public static int[] merge(int[] arr1,int[] arr2,int n,int m){
        int k=n+m-1;
        int i=n-1;
        int j=m-1;
        while(i>=0&&j>=0){
            if(arr1[i]>arr2[j]){
                arr1[k--]=arr1[i--];
            }else{
                arr1[k--]=arr2[j--];
            }
        }
        while(j>=0){
            arr1[k--]=arr2[j--];
        }
        return arr1;
    }

    public static void main(String[] args) {
        int[] arr1=new int[7];
        arr1[0]=1;
        arr1[1]=3;
        arr1[2]=5;
        int[] arr2={2,4,4,5};
        System.out.println(Arrays.toString(merge(arr1,arr2,3,4)));
    }
    //打印出现过的字符
    public static String fun(String str){
        boolean[] arr=new boolean[127];//默认false
        StringBuilder stringBuilder=new StringBuilder("");
        for (int i = 0; i < str.length(); i++) {
            char ch=str.charAt(i);
            if(arr[ch]==false){
                stringBuilder.append(ch);
                arr[ch]=true;    //打印过的字符设置为true
            }
        }
        return stringBuilder.toString();
    }
    public static void main1(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while(scanner.hasNextLine()){
            String str=scanner.nextLine();
            String ret=fun(str);//获得需要数组
            System.out.println(ret);
        }
    }

}
