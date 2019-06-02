package handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import util.LoginUtil;
import util.SessionUtil;

/**
 * @author HT
 * @version V1.0
 * @package handler
 * @date 2019-05-14 18:00
 */
public class AuthHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(!SessionUtil.hasLogin(ctx.channel())) {
            ctx.channel().close();
        } else {
            // 移除该handler
            ctx.pipeline().remove(this);
            super.channelRead(ctx, msg);
        }
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        if(SessionUtil.hasLogin(ctx.channel())) {
            System.out.println("当前连接登陆验证完毕，无需再次验证，AuthHandler被移除");
        } else {
            System.out.println("无登陆验证，强制关闭连接");
        }
    }
}
