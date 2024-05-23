package Demo1;

import java.util.Comparator;

/**
 * @auther falls_vc
 * description:
 * @date 2024/5/23  20:12
 */
public class NameDecComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o2.compareTo(o1);
    }
}
