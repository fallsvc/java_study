package work3;

import java.util.Arrays;
import java.util.Comparator;

public class Task implements Comparable<Task>{
  private int priorityLevel = 0; // 数值越大优先级越高
  private int cost = 0; // 任务消耗的时间 
  public Task(int p, int c) {
      // 待完成
      this.priorityLevel=p;
      this.cost=c;
  }
  @Override
  public int compareTo(Task o) {
      // 待完成
    return this.priorityLevel-o.getPriorityLevel();
  }
  // 根据优先级排序，优先级高则排列在前
  public static void sortByPriority(Task[] tasks) {
      // 待完成
    Arrays.sort(tasks);
  }
  // 根据消耗排序，消耗越低则排列在前
  public static void sortByCost(Task[] tasks) {
      // 待完成
    Arrays.sort(tasks,(o1,o2)->{
      return o2.getCost()- o1.getCost();
    });
  }
  // 待完成：标准名称胡Getter和Setter方法

  public int getPriorityLevel() {
    return priorityLevel;
  }

  public void setPriorityLevel(int priorityLevel) {
    this.priorityLevel = priorityLevel;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }
}
