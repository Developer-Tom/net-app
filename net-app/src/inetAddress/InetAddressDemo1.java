package inetAddress;

import java.net.InetAddress;

public class InetAddressDemo1 {
    public static void main(String[] args)throws Exception {
        //获取本机地址对象
        InetAddress ip1=InetAddress.getLocalHost();
        System.out.println(ip1.getHostAddress());
        System.out.println(ip1.getHostName());
        //获取域名ip对象
        InetAddress ip2 =InetAddress.getByName("www.github.com");
        System.out.println(ip2.getHostName());
        System.out.println(ip2.getHostAddress());
        //获取公网ip
        InetAddress ip3 =InetAddress.getByName("182.61.200.6");
        System.out.println(ip3.getHostName());
        System.out.println(ip3.getHostAddress());
        //判断是否能通， ping 5s之前测试是否可通
        System.out.println(ip3.isReachable(5000));
    }
}
