package demo2;

/**
 * @auther falls_vc
 * description:
 * @date 2024/6/11  18:40
 */
public class Test {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList=new MyArrayList<>(20);
        myArrayList.add(10);
        myArrayList.add(20);
        myArrayList.show();
        MyArrayList<Integer> myArrayList1=new MyArrayList<>(myArrayList);

        System.out.println(myArrayList1);
    }
}
