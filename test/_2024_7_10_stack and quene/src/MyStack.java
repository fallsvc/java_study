import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/10  10:12
 */
public class MyStack {
    public int[] elem;
    public int usedSize;

    public MyStack(){
        this.elem=new int[10];
    }
    public void push(int val) {
        if(isFull()) {
            this.elem = Arrays.copyOf(elem,2*elem.length);
        }
        elem[usedSize++] = val;
    }

    public boolean isFull() {
        return usedSize == elem.length;
    }

    public int pop() {
        if(usedSize<=0){
            throw new EmptyStackException("null exception");
        }
        usedSize--;
        return elem[usedSize];
    }
    //获取栈顶元素 但是不删除
    public int peek() {
        if(usedSize==0){
            throw new EmptyStackException("null exception");
        }
        return elem[usedSize-1];
    }

    public boolean isEmpty(){
        if(usedSize==0){
            return true;
        }

        return false;
    }
}
