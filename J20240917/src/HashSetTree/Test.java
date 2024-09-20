package HashSetTree;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/9/17  10:07
 */
public class Test {
    //前k个高频词
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map=new HashMap<>();
        //1.放入map
        for (String x :
                words) {
            if (map.containsKey(x)){
                int val=map.get(x);
                map.put(x,val+1);
            }else{
                map.put(x,1);
            }
        }
        //2.建立小根堆
        Queue<Map.Entry<String,Integer>> queue=new PriorityQueue<>(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue().compareTo(o2.getValue())==0){
                    return o2.getKey().compareTo(o1.getKey());
                }
              return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Integer> entry :
                map.entrySet()) {
            if(queue.size()<k){
                queue.offer(entry);
            }else{
                Map.Entry<String,Integer> e=queue.peek();
                if(e.getValue().compareTo(entry.getValue())<0){
                    queue.poll();
                    queue.offer(entry);
                }else if(e.getValue().compareTo(entry.getValue())==0){
                    if(e.getKey().compareTo(entry.getKey())>0){
                        queue.poll();
                        queue.offer(entry);
                    }
                }
            }
        }
        //转成链表
        ArrayList<String> arr=new ArrayList<>();
        while(!queue.isEmpty()){
            Map.Entry<String,Integer> entry=queue.poll();
            arr.add(entry.getKey());
        }
        Collections.reverse(arr);

        return arr;
    }
    //坏键盘打字
    public void printBrokenKeys(String str1,String str2){
        Set<Character> set=new HashSet<>();
        for (int i = 0; i < str1.length(); i++) {
            set.add(str1.charAt(i));
        }

        Set<Character> set1=new HashSet<>();
        for (int i = 0; i < str2.length(); i++) {
            Character ch=str2.charAt(i);
            if(!set.contains(ch)&&!set1.contains(ch)){
                set1.add(ch);
                System.out.print(ch);
            }
        }
    }
    //宝石与石头
    public int numJewelsInStones(String jewels,String stones){
        HashSet<Character> hashSet=new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            hashSet.add(jewels.charAt(i));
        }
        int count=0;
        for (int i = 0; i < stones.length(); i++) {
            Character ch=stones.charAt(i);
            if(hashSet.contains(ch)){
                count++;
            }
        }

        return count;
    }

    //随机链表复制 每个节点有next 和 random 引用
    static class Node{
        int val;
        Node next;
        Node Rondom;
        public Node(int val){
            this.val=val;
        }
    }
    public Node copyRandomList(Node head) {
        HashMap<Node,Node> map=new HashMap<>();
        Node cur=head;
        while(cur!=null){
            int val=cur.val;
            Node node=new Node(val);
            map.put(cur,node);
            cur=cur.next;
        }
        cur=head;
        while(cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).Rondom=map.get(cur.Rondom);
            cur=cur.next;
        }
        return map.get(head);
    }
    //只出现一次的单词
    public static void main(String[] args) {
        String[] array={"hello","add","hello","be","add"};
        String ret=appearOnceWord(array);

        System.out.println(ret);
    }

    private static String appearOnceWord(String[] array) {
        Set<String> set=new HashSet<>();
        for (String x :
                array) {
            if (set.contains(x)){
                set.remove(x);
            }else{
                set.add(x);
            }
        }
        Iterator<String> iterator=set.iterator();
        return iterator.next();
    }

    //单词出现的次数
    public static void main4(String[] args) {
        String[] words={"apple","be","student","be"};
        HashMap<String,Integer> hashMap=countWords(words);
        printHashMap(hashMap);

    }

    private static void printHashMap(HashMap<String, Integer> hashMap) {
        Set<Map.Entry<String,Integer>> set=hashMap.entrySet();
        for (Map.Entry<String, Integer> entry:set) {
            System.out.println("key="+entry.getKey()+"     val="+entry.getValue());
        }
    }

    private static HashMap<String, Integer> countWords(String[] words) {
        HashMap<String,Integer> hashMap=new HashMap<String, Integer>();
        for (int i = 0; i < words.length; i++) {
            String ch=words[i];
            if(hashMap.containsKey(ch)){
                int val=hashMap.get(ch);
                hashMap.put(ch,val+1);
            }else{
                hashMap.put(ch,1);
            }
        }
        return hashMap;
    }

    public static void main1(String[] args) {
        HashMap<String,Integer> hashMap=new HashMap<String, Integer>();


        HashBuck<String,Integer> hashBuck=new HashBuck<>();
        hashBuck.put("kffg",5);
        hashBuck.put("ffg",5);
        hashBuck.put("affg",5);
        hashBuck.remove("ffg");
//        hashBuck.put("effg",5);
//        hashBuck.put("tffg",5);
//        hashBuck.put("uffg",5);
//        hashBuck.put("jhfg",5);
//        hashBuck.put("gdfg",5);
//        hashBuck.put("ktrg",5);
//        hashBuck.put("hgffg",5);
//        hashBuck.put("k",5);
    }
}
