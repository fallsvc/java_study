package file.first;

import java.io.*;
import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/2  14:24
 */
public class Demo4 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入目录：");
        String dir=scanner.next();
        File file=new File(dir);
        if(!file.isDirectory()){
            System.out.println("这不是目录");
            return;
        }
        System.out.println("输入关键字");
        String keyWord=scanner.next();

        scanDir(file,keyWord);
    }

    private static void scanDir(File file, String keyWord) {
        File[] files=file.listFiles();
        if(files==null){
            return;
        }
        for (File x :files) {
            if(x.isFile()){
                // 普通文件
                dealFile(x,keyWord);
            }else {
                scanDir(x,keyWord);
            }
        }
    }

    private static void dealFile(File x, String keyWord) {
        if(x.getName().contains(keyWord)){
            System.out.println("文件名包含keyword"+x.getAbsoluteFile());
            return;
        }
        StringBuilder stringBuilder=new StringBuilder();

        try(Reader reader=new FileReader(x)){
            while (true){ char[] chars=new char[1024];
            int n=reader.read(chars);
            if(n==-1){
                break;
            }
            stringBuilder.append(chars,0,n);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        if(stringBuilder.indexOf(keyWord)>=0){
            System.out.println("内容包含"+x.getAbsoluteFile());
        }
    }
}
