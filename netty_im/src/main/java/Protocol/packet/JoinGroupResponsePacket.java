package Protocol.packet;

import lombok.Data;

import static Protocol.command.Command.JOIN_GROUP_RESPONSE;

/**
 * @author HT
 * @version V1.0
 * @package Protocol.packet
 * @date 2019-05-14 21:47
 */
@Data
public class JoinGroupResponsePacket extends Packet{
    private String groupId;

    private boolean success;

    private String reason;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_RESPONSE;
    }
}
