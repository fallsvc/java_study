package exception;

import java.io.FileNotFoundException;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/12  18:17
 */
public class Demo1 {
    public static void main(String[] args) throws LogException {
        throw new LogException("hh");
    }
    public static void test1(){
        int[] array={1,2,3};
        System.out.println(array[100]);
    }
    public static void main7(String[] args) {
        try {
            test1();
        }catch (ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
    }
    public static void main6(String[] args) {
//        try{
//            return 2;
//        }catch (){
//
//        }finally {
//            return 3;
//        }
    }
    public static void main5(String[] args) {
//        try{
//            // 打开资源
//
//            return; // 提前返回
//        }catch (xxException exception){
//
//        }finally {
//            // 此时这里需要释放打开的资源
//        }
//        // 这里代码不会执行到
    }
    public static void main4(String[] args) {
        try{

        }catch (NullPointerException exception){

        }catch (Exception exception){

        }finally {

        }
    }
    public static void main3(String[] args) {
//        try{
//          // 可能抛出异常代码
//        }catch (XXXException e){
//            // 自己逻辑处理异常
//        }catch (XXXException e){
//            // 自己逻辑处理异常
//        }finally {
//            // 结束后一定需要处理的逻辑
//            // 一定会被执行
//        }
    }
    public static void test() throws FileNotFoundException {
        throw new FileNotFoundException();
    }

    public static void main2(String[] args) throws FileNotFoundException{
        test();
    }
    public static void main1(String[] args) {
//        boolean flag=true;
//
//        if(flag!=true){
//            return;
//        }
//        flag=startGame();
//        if(flag!=true){
//            return;
//        }
//        flag=run();
//

//        try{
//            操作
//        }catch (异常){
//            处理
//        }

//        // 传入数组为null
//        if(array==null){
//            throw new NullPointerException();
//        }


    }
}
