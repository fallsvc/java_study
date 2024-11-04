package file.bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/2  10:09
 */
public class Demo2outputstream {
    public static void main(String[] args) {
        // 清空文件再写 true就采用追加写
        try(OutputStream outputStream=new FileOutputStream("./out.txt",true)){
//            outputStream.write(97);
//            outputStream.write(98);
//            outputStream.write(99);

            byte[] wi={99,98,99};
            outputStream.write(wi);
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
