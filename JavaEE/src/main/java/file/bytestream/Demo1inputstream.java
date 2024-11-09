package file.bytestream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/1  20:21
 */
public class Demo1inputstream {
    public static void main(String[] args) throws IOException {
//        InputStream inputStream=null;
//       try{
//           inputStream=new FileInputStream("./test.txt");
//       }finally{
//           // finally关闭资源
//           inputStream.close();
//       }
        // try with resource 实现closable接口才能放入()
        try(InputStream inputStream=new FileInputStream("./test.txt")){
            // 读文件
            // 一次读一个字节
//            while(true){
//                int data=inputStream.read();
//                if(data==-1){
//                    // 读完
//                    break;
//                }
//                System.out.println(data);
//            }
            while (true) {
                // 一次读多个字节
                byte[] data=new byte[3];
                // n 实际读取字节数
                int n=inputStream.read(data);
                System.out.println("n="+n);
                if(n==-1){
                    // 读完
                    break;
                }
                
                for (int i=0;i<n;i++) {
                    System.out.printf("%x\n",data[i]);
                }
                System.out.println("============================");
            }
        }
    }
}
