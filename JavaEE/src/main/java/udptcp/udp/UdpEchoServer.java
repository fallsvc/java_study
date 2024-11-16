package udptcp.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/9  9:55
 */
public class UdpEchoServer {
    private DatagramSocket socket=null;

    public UdpEchoServer(int port) throws SocketException {
        // 指定一个固定端口号
        socket=new DatagramSocket(port);
    }
    public void start() throws IOException {
        // 启动服务器
        System.out.println("服务器启动");

        while(true){
            // 循环接受请求并解析
            // new byte[] 存UDP载荷
            DatagramPacket requestPacket=new DatagramPacket(new byte[4096],4096);
            socket.receive(requestPacket);
            // 读取二进制有效数据
            String request=new String(requestPacket.getData(),0,requestPacket.getLength());

            // 处理请求
            String response=process(request);

            // 回应请求
            DatagramPacket responsePacket=new DatagramPacket(response.getBytes(),response.getBytes().length,
                    requestPacket.getSocketAddress()); // 创建回应报
            System.out.printf("IP:%s,port:%s ",responsePacket.getAddress().toString(),requestPacket.getPort() );
            //
            socket.send(responsePacket);

            //

        }
    }

    // private 不能被重写
    public String process(String request) {
        return request;
    }

    public static void main(String[] args) throws IOException {
        UdpEchoServer server=new UdpEchoServer(9090);
        server.start();
    }
}
