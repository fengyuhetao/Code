package traditonalIO;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author HT
 * @version V1.0
 * @package traditonalIO
 * @date 2019-05-13 11:43
 */
public class IOServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);

        // 接收新连接线程
        new Thread(() -> {
            while (true) {
                try {
//                    阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();

                    // 每个新的连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        System.out.println("新的连接");
                        try {
                            int len;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();

                            // 按字节流的方式读取数据
                            while((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }).start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
