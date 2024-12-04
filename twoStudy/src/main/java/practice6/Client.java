package practice6;

import java.io.IOException;
import java.net.Socket;

public class Client {
  public static void main(String[] args) throws IOException {
    String ip = "localhost";
    int port = 4567;
    Socket socket = new Socket(ip, port); // 创建客户端，连接服务端
    new Thread(new ChatTask(socket)).start(); // 创建线程来运行聊天任务
  }
}