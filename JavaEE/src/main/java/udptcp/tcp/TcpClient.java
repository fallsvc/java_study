package udptcp.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/15  10:33
 */
public class TcpClient {
    private Socket socket=null;

    // 以目标服务端的ip 和端口号 创建socket
    public TcpClient(String serverIp,int serverPort) throws IOException {
        socket=new Socket(serverIp,serverPort);
    }
    public void start(){
        Scanner scanner=new Scanner(System.in);
        try(InputStream inputStream=socket.getInputStream();
            OutputStream outputStream=socket.getOutputStream()) {

                Scanner scannerNet=new Scanner(inputStream);
                PrintWriter printWriter=new PrintWriter(outputStream);
                while(true) {
                    // 1、控制台输入
                    String request=scanner.next();
                    // 2. 发送服务器
                    printWriter.println(request);
                    printWriter.flush();

                    // 3.读取回应
                    String response=scannerNet.next();
                    // 4.打印到控制台
                    System.out.println(response);
                }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        TcpClient tcpClient=new TcpClient("127.0.0.1",9090);
        tcpClient.start();
    }
}
