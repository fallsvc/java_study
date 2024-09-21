package demo2;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/11  18:17
 */
public class MyArrayList<T> {
    private Object[] array;
    private int defaultValue=10;

    private int size;

    public MyArrayList() {
       array=new Object[defaultValue];
    }
    public MyArrayList(int initSize){
        array=new Object[initSize];
    }
    public MyArrayList(MyArrayList<? extends T> c){
       size=c.size;
       array=c.array;
    }
    public void add(T t){
        array[size]=t;
        size++;
    }

    public void show(){
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }
    @Override
    public String toString() {
        return "MyArrayList{" +
                "array=" + Arrays.toString(array) +
                ", defaultValue=" + defaultValue +
                ", size=" + size +
                '}';
    }
}
