package socket3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 创建Socket服务端
 */
public class SeverDemo1 {
    public static void main(String[] args) {
        System.out.println("========服务端启动=========");
        try {
            //注册端口
            ServerSocket serverSocket=new ServerSocket(7777);
            //调用accept方法，等待接受客户端的Socket连接请求，建立管道
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+"上线了");
                new SeverThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
