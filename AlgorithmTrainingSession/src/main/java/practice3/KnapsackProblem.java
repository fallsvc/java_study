package practice3;

import java.util.Arrays;
import java.util.Comparator;

public class KnapsackProblem {

    static class Item {
        int weight;
        int value;
        double valueDensity; // 价值密度 = 价值/重量
        
        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
            this.valueDensity = (double)value / weight;
        }
    }

    public static double greedyKnapsack(int capacity, Item[] items) {
        // 按价值密度从高到低排序
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item a, Item b) {
                return Double.compare(b.valueDensity, a.valueDensity);
            }
        });

        double totalValue = 0.0;
        int remainingCapacity = capacity;

        for (Item item : items) {
            if (remainingCapacity <= 0) {
                break;
            }
            
            // 如果能装下整个物品
            if (item.weight <= remainingCapacity) {
                totalValue += item.value;
                remainingCapacity -= item.weight;
                System.out.println("装入完整物品: 重量=" + item.weight + ", 价值=" + item.value);
            } else {
                // 只能装入部分物品
                double fraction = (double)remainingCapacity / item.weight;
                totalValue += item.value * fraction;
                System.out.println("装入部分物品: 重量=" + item.weight + ", 价值=" + item.value + 
                                 ", 装入比例=" + fraction);
                remainingCapacity = 0;
            }
        }

        return totalValue;
    }

    public static void main1(String[] args) {
        int capacity = 50; // 背包容量
        Item[] items = {
            new Item(10, 60),  // 物品1: 重量10, 价值60
            new Item(20, 100), // 物品2: 重量20, 价值100
            new Item(30, 120)  // 物品3: 重量30, 价值120
        };

        double maxValue = greedyKnapsack(capacity, items);
        System.out.println("背包中物品的最大总价值: " + maxValue);
    }

    public static void main(String[] args) {
        // 测试用例1：基础案例
        Item[] items1 = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(30, 120)
        };
        System.out.println("测试用例1 (容量=50):");
        System.out.println("最大价值: " + greedyKnapsack(50, items1));

        // 测试用例2：刚好装满
        Item[] items2 = {
                new Item(10, 60),
                new Item(20, 100),
                new Item(20, 80)
        };
        System.out.println("\n测试用例2 (容量=50):");
        System.out.println("最大价值: " +greedyKnapsack(50, items2));

        // 测试用例3：容量不足
        Item[] items3 = {
                new Item(30, 120),
                new Item(50, 200),
                new Item(10, 60)
        };
        System.out.println("\n测试用例3 (容量=20):");
        System.out.println("最大价值: " + greedyKnapsack(20, items3));

        // 测试用例4：0-1背包测试
        Item[] items4 = {
                new Item(5, 50),
                new Item(10, 60),
                new Item(20, 140)
        };
        System.out.println("\n测试用例4 (0-1背包 容量=30):");
        System.out.println("近似最大价值: " + greedyKnapsack(30, items4));
    }
}