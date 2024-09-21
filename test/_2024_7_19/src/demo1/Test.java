package demo1;

/**
 * @auther falls_vc
 * description:
 * @date 2024/7/19  13:06
 */
public class Test {
    public static void main(String[] args) {
        TestHeap testHeap=new TestHeap();
        int[] array={27,15,19,18,28,34,65,49,25,37 };
        testHeap.setElem(array);
        testHeap.createHeap();
        testHeap.push(80);
        testHeap.heapSort();
        System.out.println(testHeap.toString());

    }
}
