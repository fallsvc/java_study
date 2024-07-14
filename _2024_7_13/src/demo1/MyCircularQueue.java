package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/13  16:28
 */
public class MyCircularQueue {
    int[] array;
    int Front;
    int Rear;

    public MyCircularQueue(int k) {
        array=new int[k+1];
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            array[Front]=value;
        }else{
            array[Rear]=value;
        }
        Rear=(Rear+1)%array.length;
        return true;
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        Front=(Front+1)%array.length;
        return true;
    }

    public int Front() {
        return array[Front];
    }

    public int Rear() {
        return array[Rear];
    }

    public boolean isEmpty() {
        if(Rear==Front){
            return true;
        }
        return false;
    }

    public boolean isFull() {
        if((Rear+1)%array.length==Front){
            return true;
        }
        return false;
    }
}
