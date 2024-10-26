package thread.timer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/24  20:19
 */
//abstract class MyTimerTask implements Runnable{
//    @Override
//    public abstract void run();
//}

class MyTimerTask implements Comparable<MyTimerTask>{
    private Runnable task;
    private long time;
    public MyTimerTask(Runnable runnable,long time){
        this.task=runnable;
        this.time=time;
    }
    @Override
    public int compareTo(MyTimerTask o) {
        return Long.compare(this.time, o.time);
    }

    public long getTime() {
        return time;
    }

    public void run() {
        task.run();
    }
}
public class MyTimer{

    private Object locker=new Object();
    private PriorityQueue<MyTimerTask> queue = new PriorityQueue<>();

    public void schedule(Runnable task,long delay){
        synchronized (locker) {
            MyTimerTask timerTask = new MyTimerTask(task,System.currentTimeMillis()+delay);
            queue.add(timerTask);
            locker.notify();
        }
    }

    public MyTimer(){
        Thread timerThread = new Thread(()-> {
                while (true) {
                    // 取队首
                    synchronized (locker) {
                        MyTimerTask timerTask = queue.peek();
                        if (timerTask == null) {
                            try {
                                locker.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            long now = System.currentTimeMillis();
                            if (timerTask.getTime() <= now) {
                                // 取队首
                                queue.poll();
                                // 执行任务
                                timerTask.run();
                            } else {
                                try {
                                    locker.wait(timerTask.getTime() - now);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }
                }
        });
        timerThread.start();
    }
}
