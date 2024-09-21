package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/3  18:38
 */
public class DataInt<T> implements Comparable {
    public Object[] objects=new Object[3];
    public T t;

    void setVal(int pos,T t){
        objects[pos]=t;
    }
    T getVal(int pos){
        return (T)objects[pos];
    }
    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
