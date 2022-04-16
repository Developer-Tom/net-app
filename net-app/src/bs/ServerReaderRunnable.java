package bs;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerReaderRunnable implements Runnable{
    private Socket socket;
    public ServerReaderRunnable(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run(){
        try(PrintStream ps=new PrintStream(socket.getOutputStream());
        ){
          ps.println("HTTP/1.1 200 OK");
          ps.println("Content-Type:text/html;charset=UTF-8");
          ps.println();
          //经过上面步骤才可以发消息
            ps.println("<span style='color:red;font-size:90px'>《朱磊爱王瑜》 </span>");


        }catch(Exception e){
            System.out.println(socket.getRemoteSocketAddress()+"下线了");
            // e.printStackTrace();
        }
    }

}
