package demoStack;

import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/29  20:14
 */
public class MyStack<T> {
     public Object[] array;
     public int size;

     public MyStack(){
          array = new Object[3];
     }
     public T push(T e){
          ensureCapacity();
          array[size++] = e;
          return e;
     }
     public T pop(){
          T e = peek();
          size--;
          return e;
     }
     public T peek(){
          if(empty()){
               throw new RuntimeException("栈为空，无法获取栈顶元素");
          }
          return (T)array[size-1];
     }
     public int size(){
          return size;
     }
     public boolean empty(){
          return 0 == size;
     }
     private void ensureCapacity(){
          if(size == array.length){
               array = Arrays.copyOf(array, size*2);
          }
     }
}
