package udp2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ClientDemo1 {
    public static void main(String[] args) throws Exception{
        System.out.println("=============客户端启动=========");
        //创建发送端对象(人）
        DatagramSocket socket=new DatagramSocket();
        //创建一个数据包对象封装数据（韭菜盘子）
        //public DatagramPacket(byte buf[], int length,
        //                          InetAddress address, int port)
        /**
         * 参数1：封装要发送的数据
         * 参数2发送数据的大小
         * 参数3服务端的IP地址
         * 参数4服务端的端口
         */
        Scanner sc=new Scanner(System.in);
        while (true) {
            System.out.println("请说：");
            String msg=sc.nextLine();
            if("exit".equals(msg)){
                System.out.println("离线成功");
                socket.close();
                break;
            }
            byte[] buffer=msg.getBytes(StandardCharsets.UTF_8);
            DatagramPacket packet=new DatagramPacket(buffer, buffer.length,InetAddress.getLocalHost(),8888);
            //发送出去
            socket.send(packet);
        }
    }
}
