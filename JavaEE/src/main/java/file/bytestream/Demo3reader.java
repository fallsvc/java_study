package file.bytestream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/2  10:20
 */
public class Demo3reader {
    public static void main(String[] args) {
        try(Reader reader=new FileReader("./test.txt")){
            while(true){
                char[] buf=new char[2];
                int n=reader.read(buf);
                if(n==-1){
                    break;
                }
                System.out.println(buf);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
