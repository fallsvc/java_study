package file.bytestream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/2  10:38
 */
public class Demo4writer {
    public static void main(String[] args) throws IOException {
        try(Writer writer=new FileWriter("./test.txt",true)){
            writer.write('h');
            String s="hello  world";
            writer.write(s);
        }
    }
}
