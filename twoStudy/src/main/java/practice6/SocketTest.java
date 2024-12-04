package practice6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketTest {
  public static void main(String[] args) {
      // 根据指导书完善
    ExecutorService es= Executors.newFixedThreadPool(3);
    CountDownLatch latch=new CountDownLatch(1);
    // 提交服务端运行任务
    es.submit(() -> {
      // 服务器任务
      try(ServerSocket server = new ServerSocket(4567)) {
        latch.countDown();
        Socket s = server.accept(); // 阻塞，监听到客户端请求后返回Socket对象
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(s.getInputStream(), Charset.forName("utf-8")));){
          System.out.println("接收数据:" + reader.readLine());
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    try{
      latch.await();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    // 提交客户端运行任务
    es.submit(() -> {
      // 客户端任务
      try(Socket skt = new Socket("localhost", 4567); // 创建Socket对象，并尝试连接服务器端
          PrintWriter pw = new PrintWriter(skt.getOutputStream());){
        pw.println("你好"); // 发送文本数据
      } catch (UnknownHostException e) {
        e.printStackTrace();
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
    es.shutdown();
  }

}