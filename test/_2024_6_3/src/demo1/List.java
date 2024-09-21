package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/3  20:56
 */
public class List {
    private int[] array;
    private int size;

    public boolean contains(int toFind){
        for (int x :
                array) {
            if (x == toFind) {
                return true;
            }
        }
        return false;
    }
    public int indexOf(int toFind){

        for (int i = 0; i < array.length; i++) {
            if(array.equals(toFind)){
                return i;
            }
        }
        return -1;
    }
}
