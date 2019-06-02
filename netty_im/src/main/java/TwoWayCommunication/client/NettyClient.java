package TwoWayCommunication.client;

import Protocol.command.ConsoleCommandManager;
import Protocol.command.LoginConsoleCommand;
import Protocol.packet.LoginRequestPacket;
import Protocol.packet.MessageRequestPacket;
import Protocol.packet.PacketCodeC;
import codec.PacketDecoder;
import codec.PacketEncoder;
import handler.LifeCycleTestHandler;
import handler.request.GroupMessageRequestHandler;
import handler.request.LoginRequestHandler;
import handler.response.*;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import util.LoginUtil;
import util.SessionUtil;

import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 有个问题，服务端做端口递增连接，直到连接上。那客户端怎么知道服务端最终监听的是哪个端口呢？
 * 答: 如果在微服务体系下，客户端不需要约定好端口，都是服务端启动成功注册到微服务注册中心，将服务端的host跟绑定port信息注册上去，客户端只需要从注册中心获取服务端的信息即可建立连接
 *
 * @author HT
 * @version V1.0
 * @package Netty
 * @date 2019-05-13 15:32
 */
public class NettyClient {
    private static final int MAX_RETRY = 5;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8000;

    public static void main(String[] args) throws InterruptedException {
        Bootstrap bootstrap = new Bootstrap();
        NioEventLoopGroup group = new NioEventLoopGroup();

        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 5000)
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
//                        channel.pipeline().addLast(new LifeCycleTestHandler());
                        channel.pipeline().addLast(new PacketDecoder());
                        channel.pipeline().addLast(new LoginResponseHandler());
                        channel.pipeline().addLast(new MessageResponseHandler());
                        channel.pipeline().addLast(new CreateGroupResponseHandler());
                        // 加群响应处理器
                        channel.pipeline().addLast(new JoinGroupResponseHandler());
                        // 退群响应处理器
                        channel.pipeline().addLast(new QuitGroupResponseHandler());
                        // 获取群成员响应处理器
                        channel.pipeline().addLast(new ListGroupMembersResponseHandler());
                        channel.pipeline().addLast(new GroupMessageResponseHandler());
                        channel.pipeline().addLast(new LogoutResponseHandler());
                        channel.pipeline().addLast(new PacketEncoder());
                    }
                });
        connect(bootstrap, HOST, PORT, MAX_RETRY);
    }

    /**
     * 指数退避的方式，比如每隔 1 秒、2 秒、4 秒、8 秒，以 2 的幂次来建立连接，然后到达一定次数之后就放弃连接，
     */
    private static void connect(Bootstrap bootstrap, String host, int port, int retry) {
        bootstrap.connect(host, port).addListener(future -> {
           if(future.isSuccess()) {
               System.out.println("连接成功");
               
               // 连接成功后，启动控制台线程
               Channel channel = ((ChannelFuture)future).channel();
               startConsoleThread(channel);
           } else if(retry == 0) {
               System.err.println("重试次数已经用完，放弃连接");
           } else {
               // 第几次重连
               int order = (MAX_RETRY - retry) + 1;

               // 本次重连的间隔
               int delay = 1 << order;
               System.err.println(new Date() + ": 连接失败，第" + order + "次重连");
               bootstrap.config().group().schedule(() -> connect(bootstrap, host, port, retry - 1), delay, TimeUnit.SECONDS);
           }
        });
    }

    private static void startConsoleThread(Channel channel) {
        ConsoleCommandManager consoleCommandManager = new ConsoleCommandManager();
        LoginConsoleCommand loginConsoleCommand = new LoginConsoleCommand();

        Scanner sc = new Scanner(System.in);

        new Thread(() -> {
            while (!Thread.interrupted()) {
                if (!SessionUtil.hasLogin(channel)) {
                   loginConsoleCommand.exec(sc, channel);
                } else {
                    consoleCommandManager.exec(sc, channel);
                }
            }
        }).start();
    }

    private static void waitForLoginResponse() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ignored) {
        }
    }
}
