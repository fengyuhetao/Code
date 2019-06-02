package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * @author HT
 * @version V1.0
 * @package NIO
 * @date 2019-05-13 15:05
 */
public class NIOServer {
    public static void main(String[] args) throws IOException {
        /**
         * 负责轮询是否有新的连接
         */
        Selector serverSelector = Selector.open();

        /**
         * 负责轮询连接是否有数据可读
         */
        Selector clientSelector = Selector.open();

        new Thread(() -> {
            try {
                // 对应IO模型中的服务端启动
                ServerSocketChannel listenerChannel = ServerSocketChannel.open();
                listenerChannel.socket().bind(new InetSocketAddress(8000));
                listenerChannel.configureBlocking(false);
                listenerChannel.register(serverSelector, SelectionKey.OP_ACCEPT);

                while(true) {
                    // 检测是否有新的连接，1指的是阻塞时间为1ms
                    if(serverSelector.select(1) > 0) {
                        Set<SelectionKey> set = serverSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = set.iterator();

                        while(keyIterator.hasNext()) {
                            SelectionKey key = keyIterator.next();
                            //ServerSelector 里面注册的就是 Acceptable的类型了，获取了 key 后还判定了一次 key.isAcceptable
                            // 这个判定是不是多余
                            // 答案:虽然ServerSelectors里边注册就是OP_ACCEPT，但是nio是异步基于事件驱动的。OP_ACCEPT就是一个事件，注册到selector里，只是一个事件注册，但是什么时候执行这个事件？
                            // 需要一个事件的驱动的，而key.isAcceptable 我理解的就是一个事件触发点。所以是有必要判断的
                            if(key.isAcceptable()) {
                                try {
//                                    每来一个新连接，不需要创建一个线程，而是直接注册到clientSelector
                                    SocketChannel clientChannel = ((ServerSocketChannel)key.channel()).accept();
                                    clientChannel.configureBlocking(false);
                                    clientChannel.register(clientSelector, SelectionKey.OP_READ);
                                } finally {
                                    keyIterator.remove();
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                while(true) {
                    // 批量轮询是否有哪些连接有数据可读，阻塞时间1ms
                    if(clientSelector.select(1) > 0) {
                        Set<SelectionKey> selectionKeys = clientSelector.selectedKeys();
                        Iterator<SelectionKey> keyIterator = selectionKeys.iterator();

                        while(keyIterator.hasNext()) {
                            SelectionKey key = keyIterator.next();

                            if(key.isReadable()) {
                                try {
                                    SocketChannel clientChannel = (SocketChannel) key.channel();
                                    ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
                                    // 面向buffer
                                    clientChannel.read(byteBuffer);
                                    byteBuffer.flip();
                                    System.out.println(Charset.defaultCharset().newDecoder().decode(byteBuffer).toString());
                                } finally {
                                    keyIterator.remove();
//                                    将key对应的channel设置成准备下一次读取
                                    key.interestOps(SelectionKey.OP_READ);
                                }
                            }
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
}
