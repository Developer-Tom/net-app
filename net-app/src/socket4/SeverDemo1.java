package socket4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * 创建Socket服务端
 */
public class SeverDemo1 {
    private static ExecutorService pool=new ThreadPoolExecutor(3,5,6, TimeUnit.SECONDS, new ArrayBlockingQueue<>(2), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) {
        System.out.println("========服务端启动=========");
        try {
            //注册端口
            ServerSocket serverSocket=new ServerSocket(7777);
            while(true){
                Socket socket=serverSocket.accept();
                System.out.println(socket.getRemoteSocketAddress()+"上线了");
                Runnable target=new ServerReaderRunnable(socket);
                pool.execute(target);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
