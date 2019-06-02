package handler.request;

import Protocol.packet.LoginRequestPacket;
import Protocol.packet.LoginResponsePacket;
import Protocol.packet.PacketCodeC;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import session.Session;
import util.LoginUtil;
import util.SessionUtil;

import java.util.Date;
import java.util.UUID;

/**
 * @author HT
 * @version V1.0
 * @package handler
 * @date 2019-05-14 10:55
 */
public class LoginRequestHandler extends SimpleChannelInboundHandler<LoginRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, LoginRequestPacket loginRequestPacket) throws Exception {
        LoginResponsePacket loginResponsePacket = new LoginResponsePacket();
        loginResponsePacket.setVersion(loginRequestPacket.getVersion());
        loginResponsePacket.setUsername(loginRequestPacket.getUsername());
        // 登陆校验
        if(valid(loginRequestPacket)) {
            // 校验成功
            loginResponsePacket.setSuccess(true);
            String userId = randomUserId();
            loginResponsePacket.setUserId(userId);
            System.out.println(new Date() + "[" + loginRequestPacket.getUsername() +"]: 登陆成功");
            SessionUtil.bindSession(new Session(userId, loginRequestPacket.getUsername()), ctx.channel());
        } else {
            // 校验失败
            loginResponsePacket.setReason("账号密码校验失败");
            loginResponsePacket.setSuccess(false);
            System.out.println(new Date() + ": 登陆失败");
        }

        ctx.channel().writeAndFlush(loginResponsePacket);
    }

    private String randomUserId() {
        return UUID.randomUUID().toString().split("-")[0];
    }

    private boolean valid(LoginRequestPacket loginRequestPacket) {
        return true;
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端推出了");
        SessionUtil.unBindSession(ctx.channel());
    }
}
