package handler.request;

import Protocol.packet.CreateGroupRequestPacket;
import Protocol.packet.CreateGroupResponsePacket;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import util.IDUtil;
import util.SessionUtil;

import java.util.ArrayList;
import java.util.List;

public class CreateGroupRequestHandler extends SimpleChannelInboundHandler<CreateGroupRequestPacket> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, CreateGroupRequestPacket createGroupRequestPacket) {
        List<String> userIdList = createGroupRequestPacket.getUserIdList();

        List<String> userNameList = new ArrayList<>();

//        创建一个channel分组
        ChannelGroup channels = new DefaultChannelGroup(ctx.executor());

        // 删选出待加入群聊的用户的channel和username
        for(String userId: userIdList) {
            Channel channel = SessionUtil.getChannel(userId);
            if(channel != null) {
                channels.add(channel);
                userNameList.add(SessionUtil.getSession(channel).getUserName());
            }
        }

        // 创建群聊创建结果的响应
        String groupId = IDUtil.randomId();
        CreateGroupResponsePacket createGroupResponsePacket = new CreateGroupResponsePacket();
        createGroupResponsePacket.setSuccess(true);
        createGroupResponsePacket.setGroupId(groupId);
        createGroupResponsePacket.setUserNameList(userNameList);

        // 给每个客户端发送拉群通知
        channels.writeAndFlush(createGroupResponsePacket);
        System.out.println("群创建成功, id为:" + createGroupResponsePacket.getGroupId());
        System.out.println("群里边有: " + createGroupResponsePacket.getUserNameList());

        // 5. 保存群组相关的信息
        SessionUtil.bindChannelGroup(groupId, channels);
    }
}
