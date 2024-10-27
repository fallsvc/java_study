package file.first;

import java.io.File;
import java.io.IOException;

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
    public static void main1(String[] args) throws IOException {
//        File file=new File("C:/Users/12092/Desktop/test.txt");
        File file=new File("./test.txt");
        System.out.println(file.getParent());// 构造时的父路径
        System.out.println(file.getName());
        System.out.println(file.getPath());// 为构造对象时的路径
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getCanonicalFile());

    }

    public static void main(String[] args) throws IOException {
        File file=new File("./test.txt");
        file.createNewFile();
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
    }
}
