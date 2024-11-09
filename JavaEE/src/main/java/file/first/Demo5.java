package file.first;

import java.io.*;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/4  21:24
 */
public class Demo5 {
    public static void main(String[] args) throws IOException {
        String parent="./";
        String name="test.txt";
        File file=new File(parent,name);
        try(Writer writer=new FileWriter(file,true);
            Reader reader=new FileReader(file)){
            for (int i = 97; i < 120; i++) {
//                char ch=(char)i;
                writer.write(i);
                writer.write('\n');
            }
            StringBuilder stringBuilder=new StringBuilder();
            while(true){
                char[] buf=new char[1024];
                int ret=reader.read(buf);
                if(ret==-1){
                    break;
                }
                stringBuilder.append(buf);
            }
            System.out.println(stringBuilder.toString());
        }
    }
}
