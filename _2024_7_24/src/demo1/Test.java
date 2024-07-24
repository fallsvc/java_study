package demo1;

import java.util.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/24  12:35
 */
class Student{
    public int age;
    public String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name);
    }
}
public class Test {


    //字典中单词出现次数
    public static Map<String,Integer> countWord(String[] words){
        Map<String,Integer> map=new HashMap<>();
        for (String s:words) {
            if(map.get(s)==null){
                map.put(s,1);
            }else {
                int val=map.get(s);
                map.put(s,val+1);
            }
        }
        return map;
    }

    public static void main4(String[] args) {
        String[] words={"hqhq","hll","haha","hqhq","hqhq","hll","gg"};
        Map<String,Integer> map=countWord(words);
        Set<Map.Entry<String,Integer>> set=map.entrySet();

        for (Map.Entry<String,Integer> entry:set) {
            System.out.println("key:"+entry.getKey()+"  value:"+entry.getValue());
        }
        Iterator<Map.Entry<String,Integer>> iterator=set.iterator();
        while(iterator.hasNext()){
            Map.Entry<String,Integer> tmp=iterator.next();
            System.out.println("key:"+tmp.getKey()+"  val:"+tmp.getValue());
        }
    }
    public static void main3(String[] args) {
        HashBuck2<Student,Integer> hashBuck2=new HashBuck2<>();
        Student student1=new Student(20,"zs");
        Student student2=new Student(20,"zs");
        hashBuck2.push(student1,2);
        hashBuck2.push(student2,3);
    }
    public static void main2(String[] args) {
        HashBuck2<Integer,Integer> hashBuck=new HashBuck2<>();
//        HashBuck2<String,String>[] hashBuck2s=new HashBuck2[2];
//        System.out.println(hashBuck2s[0].array[0].val);
        hashBuck.push(1,2);
        hashBuck.push(2,3);
        hashBuck.push(11,2);        hashBuck.push(1,2);
        hashBuck.push(3,3);
        hashBuck.push(4,2);        hashBuck.push(1,2);
        hashBuck.push(5,3);
        hashBuck.push(12,2);
        hashBuck.push(13,2);

    }
    public static void main1(String[] args) {
        HashBuck hashBuck=new HashBuck();
        hashBuck.push(1,2);
        hashBuck.push(2,3);
        hashBuck.push(11,2);        hashBuck.push(1,2);
        hashBuck.push(3,3);
        hashBuck.push(4,2);        hashBuck.push(1,2);
        hashBuck.push(5,3);
        hashBuck.push(12,2);
        hashBuck.push(13,2);
    }
}
