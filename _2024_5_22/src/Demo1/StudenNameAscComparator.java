package Demo1;

import java.util.Comparator;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/22  10:53
 */
public class StudenNameAscComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.name.compareTo(o1.name);
    }
}
