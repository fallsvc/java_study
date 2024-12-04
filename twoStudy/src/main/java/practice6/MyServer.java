package practice6;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
  public static void main(String[] args) throws IOException {
    try(ServerSocket server = new ServerSocket(4567);){ // 创建服务器端，绑定端口
      while(true) { // 持续运行，负责接收不同的客户端
        final Socket toClient = server.accept(); // 阻塞，监听到客户端请求后返回Socket对象
        new Thread(new ChatTask(toClient)).start(); // 针对接收到的客户端创建一个通信通道
      }
    }
  }
}