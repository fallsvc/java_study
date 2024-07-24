package demo2;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/24  20:28
 */
public class Test {

    public List<String> topKFrequent(String[] words,int k){
        HashMap<String,Integer> map=new HashMap<>();
        //统计单词
        for (int i = 0; i < words.length; i++) {
            if(map.get(words[i])!=null){
                int val=map.get(words[i]);
                map.put(words[i],val+1);
            }else{
                map.put(words[i],1);
            }
        }
        //建立小根堆
        PriorityQueue<Map.Entry<String,Integer>> priorityQueue=new PriorityQueue<>(new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> a,Map.Entry<String,Integer> b){
                int ret=a.getValue().compareTo(b.getValue());
                if(ret==0){
                   return b.getKey().compareTo(a.getKey());
                }
                return ret;
            }
        });
        for (Map.Entry<String, Integer> x :
                map.entrySet()) {
            if(priorityQueue.size()<k){
                priorityQueue.offer(x);
            }else {
                Map.Entry<String,Integer> top=priorityQueue.peek();
                int b=top.getValue().compareTo(x.getValue());
                if(b<0){
                    priorityQueue.poll();
                    priorityQueue.offer(x);
                } else if (b==0) {
                    if(top.getKey().compareTo(x.getKey())>0){
                        priorityQueue.poll();
                        priorityQueue.offer(x);
                    }
                }
            }
        }

        ArrayList<String> list=new ArrayList<>();
        while (!priorityQueue.isEmpty()){
            Map.Entry<String,Integer> entry=priorityQueue.poll();
            list.add(entry.getKey());
        }
        Collections.reverse(list);

        return list;
    }
    public static void main(String[] args) {

    }
    //坏键盘打字
    public static void func(String s1,String s2){
        s1=s1.toUpperCase();
        s2=s2.toUpperCase();
        HashSet<Character> hashSet=new HashSet<>();
        for (int i = 0; i < s2.length(); i++) {
            hashSet.add(s2.charAt(i));
        }
        HashSet<Character> hashSet1=new HashSet<>();
        for (int i = 0; i < s1.length(); i++) {
            char ch=s1.charAt(i);
            if(!hashSet.contains(ch)&&!hashSet1.contains(ch)){
                hashSet1.add(ch);
                System.out.print(ch);
            }
        }
    }
    //宝石与石头
    public int numJewelsInStones(String jewels, String stones) {

        HashSet<Character> hashSet=new HashSet<>();
        for(int i=0;i<jewels.length();i++){
            hashSet.add(jewels.charAt(i));
        }
        int count=0;
        for(int i=0;i<stones.length();i++){
            if(hashSet.contains(stones.charAt(i))){
                count++;
            }
        }
        return count;
    }
    static class Node{
        public int val;
        public Node next;
        public Node random;
        public Node(int val){
            this.val=val;
        }
    }
    //深拷贝单链表
    public Node copyRandomList(Node head) {
        if(head==null) return head;
        Map<Node,Node> map=new HashMap<>();
        Node cur=head;
        while(cur!=null){
            Node node=new Node(cur.val);
            map.put(cur,node);
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).random=map.get(cur.random);
            cur=cur.next;
        }
        return map.get(head);
    }
    //只出现一次的数字
    public static int getOne(int[] nums){
        HashSet<Integer> hashSet=new HashSet<>();
        for (int x :
                nums) {
            if(hashSet.contains(x)){
                hashSet.remove(x);
            }else {
                hashSet.add(x);
            }
        }

        for (int x :
                nums) {
            if(hashSet.contains(x)){
                return x;
            }
        }
        return -1;
    }
    public static void main1(String[] args) {
        int[] array={1,3,2,1,2};
        System.out.println(getOne(array));
    }
}
