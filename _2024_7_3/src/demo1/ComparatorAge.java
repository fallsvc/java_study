package demo1;

import java.util.Comparator;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/3  19:33
 */
public class ComparatorAge implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.age-o2.age;
    }
}
