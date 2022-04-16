package socket5_sms;

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
        try(InputStream is=socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
        ){
            String msg;
            while((msg=br.readLine())!=null){
                System.out.println(socket.getRemoteSocketAddress()+"发送了"+msg);
                //把这个消息发送给所有客户端
                sendMsgToAll(msg);
            }

        }catch(Exception e){
            System.out.println(socket.getRemoteSocketAddress()+"下线了");
            SeverDemo1.allOnlineSockets.remove(socket);
            // e.printStackTrace();
        }
    }

    private void sendMsgToAll(String msg)throws Exception {
        for (Socket socket : SeverDemo1.allOnlineSockets) {
            PrintStream ps=new PrintStream(socket.getOutputStream());
            ps.println(msg);
            ps.flush();
        }
    }

}
