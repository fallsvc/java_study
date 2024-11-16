package udptcp.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/15  10:33
 */
public class TcpServer {
    ServerSocket serverSocket=null;

    public TcpServer(int port) throws IOException {
        serverSocket=new ServerSocket(port);
    }
    public void start() throws IOException {
        System.out.println("服务器启动：");
        while (true) {
            // 接收连接
            Socket clientSocket=serverSocket.accept();
            // 线程
//            Thread thread=new Thread(()->{
//                processConnection(clientSocket);
//            });
//            thread.start();
            // 线程池
            ExecutorService executorService= Executors.newCachedThreadPool();
            executorService.submit(()->{
                processConnection(clientSocket);
            });
        }
    }

    private void processConnection(Socket clientSocket) {
        System.out.printf("[%s:%d] 客户端上线 \n",clientSocket.getInetAddress(),clientSocket.getPort());
        try(InputStream inputStream=clientSocket.getInputStream();
            OutputStream outputStream=clientSocket.getOutputStream()){
            //
            Scanner scanner=new Scanner(inputStream);
            PrintWriter writer=new PrintWriter(outputStream);

            while (true){
                if(!scanner.hasNext()){
                    System.out.printf("[%s:%d] 客户端下线 \n",clientSocket.getInetAddress(),clientSocket.getPort());
                    break;
                }
                // 1 获取请求
                String request =scanner.next();
                // 2 处理请求
                String response=process(request);
                // 3 响应
                writer.println(response);
                writer.flush();
                // 打印日志
                System.out.printf("[%s:%d] req:%s resp:%s \n",clientSocket.getInetAddress(),clientSocket.getPort(),request,response);
            }
        }catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        TcpServer tcpServer=new TcpServer(9090);
        tcpServer.start();
    }
}
