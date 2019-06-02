package TwoWayCommunication.server;

import TwoWayCommunication.Spliter;
import codec.PacketDecoder;
import codec.PacketEncoder;
import handler.AuthHandler;
import handler.LifeCycleTestHandler;
import handler.request.*;
import handler.response.LoginResponseHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import sun.security.krb5.internal.LoginOptions;

/**
 * @author HT
 * @version V1.0
 * @package PACKAGE_NAME
 * @date 2019-05-13 11:35
 */
public class NettyServer {
    private static final int PORT = 8000;

    public static void main(String[] args) {
        /**
         * 监听端口，accept新连接的线程组
         */
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();

        /**
         * 处理每一条连接的数据读写的线程组
         */
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap
                .group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.SO_BACKLOG, 1024)
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childOption(ChannelOption.TCP_NODELAY, true)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
//                    定义后续每条连接的数据读写，业务处理逻辑
                    @Override
                    protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
//                        nioSocketChannel.pipeline().addLast(new LifeCycleTestHandler());
                        nioSocketChannel.pipeline().addLast(new Spliter());
                        nioSocketChannel.pipeline().addLast(new PacketDecoder());
                        nioSocketChannel.pipeline().addLast(new LoginRequestHandler());

                        // 处理登陆处理器
                        nioSocketChannel.pipeline().addLast(new AuthHandler());
                        nioSocketChannel.pipeline().addLast(new MessageRequestHandler());
                        nioSocketChannel.pipeline().addLast(new CreateGroupRequestHandler());
                        // 加群请求处理器
                        nioSocketChannel.pipeline().addLast(new JoinGroupRequestHandler());
                        // 退群请求处理器
                        nioSocketChannel.pipeline().addLast(new QuitGroupRequestHandler());
                        // 获取群成员请求处理器
                        nioSocketChannel.pipeline().addLast(new ListGroupMembersRequestHandler());
                        nioSocketChannel.pipeline().addLast(new GroupMessageRequestHandler());
                        nioSocketChannel.pipeline().addLast(new LogoutRequestHandler());
                        nioSocketChannel.pipeline().addLast(new PacketEncoder());
                    }
                });
        bind(serverBootstrap, PORT);
    }

    public static void bind(final ServerBootstrap serverBootstrap, final int port) {
        serverBootstrap.bind(port).addListener(new GenericFutureListener<Future<? super Void>>() {
            @Override
            public void operationComplete(Future<? super Void> future) throws Exception {
                if(future.isSuccess()) {
                    System.out.println("端口[" + port + "]绑定成功");
                } else {
                    System.err.println("端口[" + port + "]绑定失败");
                    bind(serverBootstrap, port + 1);
                }
            }
        });
    }
}
