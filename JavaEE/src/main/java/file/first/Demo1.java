package file.first;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * @auther falls_vc
 * description:
 * @date 2024/10/27  14:14
 */
public class Demo1 {
    //   / 斜杠
    //   \ 反斜杠
    //   根-》文件  绝对路径
    //   ./ 当前目录
    //  ../ 上一层路径
    // 文件操作
    // 1. 文件系统操作
    // 2. 文件内容操作-》 读写
    /**
     * 文本文件 or 二进制文件
     * @param args
     */
    public static void main(String[] args) throws IOException {
//        File file=new File("C:/Users/12092/Desktop/test.txt");
        File file=new File("./test.txt");
        System.out.println(file.getParent());// 构造时的父路径
        System.out.println(file.getName());
        System.out.println(file.getPath());// 为构造对象时的路径
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getCanonicalFile());

    }

    public static void main2(String[] args) throws IOException {
        File file=new File("./test.txt");
        file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }

    public static void main3(String[] args) throws IOException, InterruptedException {
        File file=new File("./test.txt");
//        boolean ret=file.delete();// 删除文件
        file.createNewFile();
        // 进程结束删除文件
//        file.deleteOnExit();
//        System.out.println();
//        Thread.sleep(10000);
    }

    public static void main4(String[] args) {
        File file =new File("C:/");

        String[] ret=file.list();
        System.out.println(Arrays.toString(ret));

        File[] ret1=file.listFiles();
        System.out.println(Arrays.toString(ret1));
    }

    public static void main5(String[] args) {
        File file=new File("./test");

//        boolean result=file.mkdir();//// 单个目录
//        System.out.println(result);
        file.delete();
//        file.mkdirs();// 多级目录
    }

    public static void main6(String[] args) {
        File file=new File("./test.txt");
        File file1=new File("./src/test.txt");
//        file.renameTo(file1);
        file1.renameTo(file);
    }
}
