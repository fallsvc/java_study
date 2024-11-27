package practice4.markdown;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public final class FileTool {
  public static String read(String path) {
    // 读取文件，返回文件内容
    try{
      Path path1= Paths.get(path);
      List<String> lists= Files.readAllLines(path1);
      return String.join("\n",lists);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
  public static void save(String path, String content) {
    // 保存到目标文件，content为文件内容
    Path path1=Paths.get(path);
    if(Files.exists(path1)){
      try {
        Files.delete(path1);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    try{
      Files.write(Paths.get(path),content.getBytes());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}