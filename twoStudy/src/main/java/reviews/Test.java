package reviews;

public class Test {
 public static void main(String[] args) {
 Integer x = 20;
 Integer y = 21;
 System.out.println(max(x, y));
 Double m = 28.5;
 Double n = 35.5;
 System.out.println(max(m, n));
 }
 // 函数中要求对象支持compareTo函数，因此需要给类型参数设置边界
public static <T extends Comparable<T>> T max(T o1, T o2) {
 return o1.compareTo(o2) > 0 ? o1 : o2;
 }
 }