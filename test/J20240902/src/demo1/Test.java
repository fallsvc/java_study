package demo1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/2  10:40
 */
public class Test {

    //插入排序
    public static void sort(Comparable[] array){
        for (int i = 1; i < array.length ; i++) {
            Comparable tmp=array[i];
            int j=i-1;
            for (; j>=0 ; j--) {
                if(array[j].compareTo(tmp)>0){
                    array[j+1]=array[j];
                }else {
                    array[j+1]=tmp;
                    break;
                }
            }
            array[j+1]=tmp;
        }
    }

    public static void main(String[] args) {
        Integer[] array={6,4,32,1,3};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
    public static void mai1n(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"h");
        map.put(2,"h");
        map.put(3,"l");
        Set<Map.Entry<Integer,String>> set=map.entrySet();
        for (Map.Entry<Integer,String> x:
             set) {
            System.out.println(x);
        }

    }
}
