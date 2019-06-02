package Protocol.packet;

import lombok.Data;

import static Protocol.command.Command.QUIT_GROUP_REQUEST;

/**
 * @author HT
 * @version V1.0
 * @package Protocol.packet
 * @date 2019-05-14 21:48
 */
@Data
public class QuitGroupRequestPacket extends Packet{

    private String groupId;

    @Override
    public Byte getCommand() {
        return QUIT_GROUP_REQUEST;
    }
}
