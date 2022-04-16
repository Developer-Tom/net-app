package socket3;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

public class SeverThread extends Thread{
    private Socket socket;
    public SeverThread(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run(){
        try(InputStream is=socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
        ){
            String msg;
            while((msg=br.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+"发送了"+msg);
            }

        }catch(Exception e){
            System.out.println(socket.getRemoteSocketAddress()+"下线了");
           // e.printStackTrace();
        }
    }
}
