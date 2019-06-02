package Protocol.packet;

import lombok.Data;

import static Protocol.command.Command.JOIN_GROUP_REQUEST;

/**
 * @author HT
 * @version V1.0
 * @package Protocol.packet
 * @date 2019-05-14 21:46
 */
@Data
public class JoinGroupRequestPacket extends Packet {
    private String groupId;

    @Override
    public Byte getCommand() {
        return JOIN_GROUP_REQUEST;
    }
}
