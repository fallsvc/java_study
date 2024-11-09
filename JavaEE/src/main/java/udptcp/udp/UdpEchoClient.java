package udptcp.udp;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/9  9:56
 */
public class UdpEchoClient {
    private DatagramSocket socket=null;

    private String IP=null;
    private int port;
    // 需要指定服务器地址
    public UdpEchoClient(String ip,int port) throws SocketException {
        this.IP=ip;
        this.port=port;
        socket=new DatagramSocket();
    }
    public void start() throws IOException {
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.println("请输入请求： ");
            if(!scanner.hasNext()){
                break;
            }
            String request=scanner.next();
            // 构造数据报
            DatagramPacket requestPacket=new DatagramPacket(request.getBytes(),
                    request.getBytes().length, InetAddress.getByName(IP),port);
            // 发送数据
            socket.send(requestPacket);
            // 接受响应
            DatagramPacket responsePacket=new DatagramPacket(new byte[4096],4096);

            socket.receive(responsePacket);
            // 读取数据然后打印
            String response=new String(responsePacket.getData(),0,responsePacket.getLength());
            System.out.println(response);
        }
    }

    public static void main(String[] args) throws IOException {
        UdpEchoClient udpEchoClient=new UdpEchoClient("127.0.0.1",9090);
        udpEchoClient.start();
    }
}
