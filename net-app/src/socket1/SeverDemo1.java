package socket1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.*;

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
            Socket socket=serverSocket.accept();
            //从管道中得到字节输入流
            InputStream is=socket.getInputStream();
            //包装成缓冲流
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg=br.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+":说了"+msg);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
