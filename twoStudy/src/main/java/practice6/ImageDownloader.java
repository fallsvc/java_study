package practice6;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;

public class ImageDownloader {

  public static void main(String[] args) {
    // 图片URL
    String imageUrl = "http://www.swu.edu.cn/images/20241129dongri.png";
    // 本地保存路径
    String savePath = "C:\\Users\\12092\\Desktop\\1.png";
    try {
      downloadImage(imageUrl, savePath);
      System.out.println("图片下载成功!");
    } catch (IOException | InterruptedException e) {
      e.printStackTrace();
      System.err.println("下载图片失败: " + e.toString());
    }
  }
  
  public static void downloadImage(String imageUrl, String savePath) throws IOException, InterruptedException {
    // 创建HttpClient
    HttpClient client = HttpClient.newHttpClient();
    // 创建HttpRequest
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(imageUrl))
            .build();
    // 发送请求并获取响应
    HttpResponse<InputStream> response = client.send(request, HttpResponse.BodyHandlers.ofInputStream());
    // 获取图片的输入流
    InputStream inputStream = response.body();
    // 创建文件输出流并将图片保存到本地
    Path outputPath = Path.of(savePath);
    try (OutputStream outputStream = Files.newOutputStream(outputPath)) {
      // 将输入流中的数据复制到输出文件
      inputStream.transferTo(outputStream);
    }
  }
}