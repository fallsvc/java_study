package udptcp.udp;

import java.io.IOException;
import java.net.SocketException;
import java.util.HashMap;

/**
 * @auther falls_vc
 * description:
 * @date 2024/11/15  10:10
 */
public class UdpDictServer extends UdpEchoServer{

    HashMap<String,String> hashMap=new HashMap<>();

    public UdpDictServer(int port) throws SocketException {
        super(port);
        hashMap.put("小兔子","rabbit");
        hashMap.put("小鸭子","duck");
        hashMap.put("小鸡","cock");
        hashMap.put("小鸟","bird");
    }
    @Override
    public String process(String request) {
        return hashMap.getOrDefault(request,"未找到单词");
    }

    public static void main(String[] args) throws IOException {
        UdpDictServer udpDictServer=new UdpDictServer(9090);
        udpDictServer.start();
    }
}
