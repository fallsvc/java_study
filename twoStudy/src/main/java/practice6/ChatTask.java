package practice6;

import java.io.*;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class ChatTask implements Runnable {
  private Socket socket; // 包含一个端点
  public ChatTask(Socket socket) {
      this.socket = socket;
  }
  @Override
  public void run() {
    System.out.println("开始对话");
    try {
      socket.setSoTimeout(5000); // 设置超时时间
    } catch (SocketException e) {
      e.printStackTrace();
    }
    // 独立线程处理接收数据
    new Thread(() -> {
      try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"))) {
        while (true) { // 持续运行
          if (reader.ready()) { // 可以读数据
            String message = reader.readLine(); // 读取一行消息
            System.out.println(message); // 打印到控制台
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }).start();
    // 独立线程处理输出数据任务
    new Thread(() -> {
      try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
           Scanner commd = new Scanner(System.in)) {
        while (true) { // 持续运行
          if (commd.hasNextLine()) { // 阻塞
            String message = commd.nextLine(); // 读取
            writer.println(message); // 发送
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      }
    }).start();
  }
}