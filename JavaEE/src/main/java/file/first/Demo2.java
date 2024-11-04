package file.first;

import java.io.File;
import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/2  10:53
 */
public class Demo2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入文件路径");
        String s=scanner.next();
        File file=new File(s);
        if(!file.isDirectory()){
            return;
        }
        System.out.println("请输入关键字");
        String key=scanner.next();
        scanDir(file,key);
    }

    private static void scanDir(File s, String key) {
        // 1.当前目录下的所有内容
        File[] files = s.listFiles();
        // 2. 内容为空返回
        if(files==null){
            return;
        }
        // 3.遍历当前内容
        for (File file : files) {
            if(file.isFile()) {
                // 4.如果是普通文件，看是否包含关键字
                dealFile(file,key);
            }else{
                // 5.目录继续遍历
                scanDir(file,key);
            }
        }
    }

    private static void dealFile(File file, String key) {
        if(file.getName().contains(key)){
            System.out.println("发现文件："+file.getAbsoluteFile()+"  是否删除（Y|N）");
            Scanner scanner=new Scanner(System.in);
            String s=scanner.next();
            if(s.equalsIgnoreCase("y")){
                System.out.println("文件已删除");
            }
        }
    }
}
