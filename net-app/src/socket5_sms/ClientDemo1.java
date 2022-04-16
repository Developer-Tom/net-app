package socket5_sms;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 完成Socket网络编程入门的客户端开发,多发
  */
//使用线程池通信
public class ClientDemo1 {
    public static void main(String[] args) {
        System.out.println("=========客户端启动===========");
        try {
            //创建Socket管道连接服务端
            //参数1IP地址，参数2端口
            Scanner sc=new Scanner(System.in);
             Socket socket = new Socket("127.0.0.1", 7777);
             //创建独立线程负责收消息
        new ClientReaderThread(socket).start();
             //从socket通信管道得到字节输出流，负责发送数据
            OutputStream os=socket.getOutputStream();
            //包装成打印流
            PrintStream ps=new PrintStream(os);
          while(true){
              System.out.println("请说：");
              String msg=sc.nextLine();
              ps.println(msg);
              ps.flush();
          }
            //不建议关闭通信管道
            //socket.close()

        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
class ClientReaderThread extends Thread{
    private Socket socket;
    public ClientReaderThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run(){
        try(InputStream is=socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
        ){
            String msg;
            while((msg=br.readLine())!=null){
                System.out.println("收到了"+msg);
            }

        }catch(Exception e){
            System.out.println(socket.getRemoteSocketAddress()+"被踢出");
            // e.printStackTrace();
        }
    }


}