package udp3_broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *发送端
 */
public class ServerDemo2 {
    public static void main(String[] args)throws Exception {
        System.out.println("=====服务端启动==========");
        //创建接收端对象
        DatagramSocket socket=new DatagramSocket(8888);
        //创建一个数据包对象接收数据
        byte[] buffer=new byte[1024*64];
        DatagramPacket packet=new DatagramPacket(buffer,buffer.length);
        while (true) {
            //等待接收数据
            socket.receive(packet);
            //取出数据
            int len=packet.getLength();
            String rs=new String(buffer,0,len);
            System.out.println("收到了"+rs);
            //获取发送端的ip和端口
            System.out.println(packet.getSocketAddress().toString());
            System.out.println(packet.getPort());
        }
    }


}
