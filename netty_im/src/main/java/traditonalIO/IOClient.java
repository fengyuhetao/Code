package traditonalIO;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @author HT
 * @version V1.0
 * @package traditonalIO
 * @date 2019-05-13 11:47
 */
public class IOClient {
    public static void main(String[] args) {
        System.out.println("开始");
        new Thread(() -> {
           try {
               Socket socket = new Socket("127.0.0.1", 8000);
               while(true) {
                   try {
                       socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                       Thread.sleep(2000);
                   } catch (IOException e) {
                       e.printStackTrace();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
           } catch (IOException e) {
               e.printStackTrace();
           }
        }).start();
    }
}
