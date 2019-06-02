package handler.request;

import Protocol.packet.JoinGroupRequestPacket;
import Protocol.packet.JoinGroupResponsePacket;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import util.SessionUtil;

/**
 * @author HT
 * @version V1.0
 * @package handler.request
 * @date 2019-05-14 21:52
 */
public class JoinGroupRequestHandler extends SimpleChannelInboundHandler<JoinGroupRequestPacket>{
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, JoinGroupRequestPacket joinGroupRequestPacket) throws Exception {
        // 获取群对应的channelGroup，然后将当前用户的channel加进去
        String groupId = joinGroupRequestPacket.getGroupId();

        ChannelGroup channels = SessionUtil.getChannelGroup(groupId);
        channels.add(ctx.channel());

        // 构造加群响应发送给客户端
        JoinGroupResponsePacket joinGroupResponsePacket = new JoinGroupResponsePacket();
        joinGroupResponsePacket.setSuccess(true);
        joinGroupResponsePacket.setGroupId(groupId);
        ctx.channel().writeAndFlush(joinGroupResponsePacket);
    }
}
