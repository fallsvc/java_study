package practice3;

/**
 * @auther falls_vc
 * description:
 * @date 2025/4/7  19:30
 */
import java.util.Arrays;
import java.util.Comparator;

public class JobScheduling {

    static class Job {
        int id;     // 作业编号
        int profit; // 作业效益
        int deadline; // 作业截止期限

        public Job(int id, int profit, int deadline) {
            this.id = id;
            this.profit = profit;
            this.deadline = deadline;
        }
    }

    public static void scheduleJobs(Job[] jobs) {
        // 1. 按照效益从高到低排序
        Arrays.sort(jobs, new Comparator<Job>() {
            @Override
            public int compare(Job a, Job b) {
                return b.profit - a.profit;
            }
        });

        int n = jobs.length;
        // 找到最大的截止期限
        int maxDeadline = 0;
        for (Job job : jobs) {
            if (job.deadline > maxDeadline) {
                maxDeadline = job.deadline;
            }
        }

        // 初始化时间槽，timeSlot[i]表示第i个时间单位是否被占用
        int[] timeSlot = new int[maxDeadline + 1];
        Arrays.fill(timeSlot, -1); // -1表示空

        int totalProfit = 0;

        // 2. 遍历排序后的作业列表
        for (int i = 0; i < n; i++) {
            // 从作业的截止期限开始向前寻找可用的时间槽
            for (int j = jobs[i].deadline; j > 0; j--) {
                if (timeSlot[j] == -1) {
                    timeSlot[j] = jobs[i].id;
                    totalProfit += jobs[i].profit;
                    break;
                }
            }
        }

        // 输出结果
        System.out.println("作业调度顺序：");
        for (int i = 1; i <= maxDeadline; i++) {
            if (timeSlot[i] != -1) {
                System.out.println("时间 " + i + ": 作业 " + timeSlot[i]);
            }
        }
        System.out.println("总效益: " + totalProfit);
    }

    public static void main1(String[] args) {
        Job[] jobs = {
                new Job(1, 100, 2),
                new Job(2, 19, 1),
                new Job(3, 27, 2),
                new Job(4, 25, 1),
                new Job(5, 15, 3)
        };

        scheduleJobs(jobs);
    }
    public static void main(String[] args) {
        // 测试用例1：基础案例
        Job[] jobs1 = {
                new Job(1, 100, 2),
                new Job(2, 19, 1),
                new Job(3, 27, 2),
                new Job(4, 25, 1),
                new Job(5, 15, 3)
        };
        System.out.println("测试用例1:");
        scheduleJobs(jobs1);

        // 测试用例2：所有作业都能安排
        Job[] jobs2 = {
                new Job(1, 40, 4),
                new Job(2, 35, 3),
                new Job(3, 30, 2),
                new Job(4, 25, 1)
        };
        System.out.println("\n测试用例2:");
        scheduleJobs(jobs2);

        // 测试用例3：只有一个作业
        Job[] jobs3 = {
                new Job(1, 50, 1)
        };
        System.out.println("\n测试用例3:");
        scheduleJobs(jobs3);

        // 测试用例4：相同截止期限
        Job[] jobs4 = {
                new Job(1, 30, 2),
                new Job(2, 40, 2),
                new Job(3, 20, 2)
        };
        System.out.println("\n测试用例4:");
        scheduleJobs(jobs4);
    }
}
