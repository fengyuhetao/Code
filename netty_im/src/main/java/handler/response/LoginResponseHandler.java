package handler.response;

import Protocol.packet.LoginRequestPacket;
import Protocol.packet.LoginResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import session.Session;
import util.SessionUtil;

import java.util.Date;

/**
 * @author HT
 * @version V1.0
 * @package handler.response
 * @date 2019-05-14 11:00
 */
public class LoginResponseHandler extends SimpleChannelInboundHandler<LoginResponsePacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginResponsePacket loginResponsePacket) throws Exception {
        String userId = loginResponsePacket.getUserId();
        String userName = loginResponsePacket.getUsername();

        if(loginResponsePacket.isSuccess()) {
            System.out.println(new Date() + ": 【" + userName + "】【"+ userId +"】 客户端登陆成功");
            SessionUtil.bindSession(new Session(userId, userName), ctx.channel());
        } else {
            System.out.println(new Date() + ": 【" + userName + "】 登陆失败, 原因 -> " + loginResponsePacket.getReason());
        }
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端连接被关闭");
    }
}
