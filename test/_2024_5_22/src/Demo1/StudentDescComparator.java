package Demo1;

import java.util.Comparator;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/22  10:36
 */
public class StudentDescComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.age- o1.age;
    }
}
