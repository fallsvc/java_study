package demo1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/13  15:55
 */
public class QToS {
    Queue<Integer> qu1;
    Queue<Integer> qu2;

    public QToS() {
        qu1=new LinkedList<>();
        qu2=new LinkedList<>();
    }

    public void push(int x) {
        if(!qu1.isEmpty()){
            qu1.offer(x);
        }else{
            qu2.offer(x);
        }
    }

    public int pop() {
        if(empty()){
            return -1;
        }
        int retVal=0;
        if(qu1.isEmpty()){
            int n=qu2.size()-1;
            for(int i=0;i<n;i++){
                qu1.offer(qu2.poll());
            }
            retVal=qu2.poll();
        }else{
            int n=qu1.size()-1;
            for(int i=0;i<n;i++){
                qu2.offer(qu1.poll());
            }
            retVal=qu1.poll();
        }

        return retVal;
    }

    public int top() {
        if(empty()){
            return -1;
        }
        int retVal=0;
        if(qu1.isEmpty()){
            int n=qu2.size()-1;
            for(int i=0;i<n;i++){
                qu1.offer(qu2.poll());
            }
            retVal= qu2.poll();
            qu1.offer(retVal);
        }else{
            int n=qu1.size()-1;
            for(int i=0;i<n;i++){
                qu2.offer(qu1.poll());
            }
            retVal=qu1.poll();
            qu2.offer(retVal);
        }

        return retVal;
    }

    public boolean empty() {
        if(qu1.size()+qu2.size()==0){
            return true;
        }
        return false;
    }
}
