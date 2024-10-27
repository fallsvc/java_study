package bite.problems.threadpoolandtimer;

import java.util.PriorityQueue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/27  22:20
 */
class MyTimerTask implements Comparable<MyTimerTask>{
    private Runnable task;
    private long time;

    public MyTimerTask(Runnable task,long time){
        this.task=task;
        this.time=time;
    }
    @Override
    public int compareTo(MyTimerTask o) {
        return (int)(this.time-o.time);
    }
    public long getTime(){
        return time;
    }
    public void run(){
        task.run();
    }
}
public class MyTimer {
    private Object locker1=new Object();
    private PriorityQueue<MyTimerTask> priorityQueue=new PriorityQueue<>();

    public void schedule(Runnable runnable,long time){
        synchronized (locker1){
            MyTimerTask myTimerTask=new MyTimerTask(runnable,System.currentTimeMillis()+time);
            priorityQueue.offer(myTimerTask);
            locker1.notify();
        }
    }
    public MyTimer(){
        Thread thread=new Thread(()->{
            while(true){
                synchronized (locker1){
                    MyTimerTask myTimerTask=priorityQueue.peek();
                    if(myTimerTask==null){
                        try {
                            locker1.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }else {
                        long now=System.currentTimeMillis();
                        if(myTimerTask.getTime()<now){
                            priorityQueue.poll();
                            myTimerTask.run();
                        }else{
                            try {
                                locker1.wait(myTimerTask.getTime()-now);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        });
        thread.start();
    }
}
