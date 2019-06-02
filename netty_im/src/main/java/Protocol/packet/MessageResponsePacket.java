package Protocol.packet;

import lombok.Data;

import static Protocol.command.Command.MESSAGE_RESPONSE;

/**
 * @author HT
 * @version V1.0
 * @package Protocol
 * @date 2019-05-13 22:22
 */
@Data
public class MessageResponsePacket extends Packet {
    private String fromUserId;

    private String fromUserName;

    private String message;

    @Override
    public Byte getCommand() {
        return MESSAGE_RESPONSE;
    }
}
