package Protocol.packet;

import io.netty.handler.codec.MessageToByteEncoder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static Protocol.command.Command.MESSAGE_REQUEST;

/**
 * @author HT
 * @version V1.0
 * @package Protocol
 * @date 2019-05-13 22:22
 */
@Data
public class MessageRequestPacket extends Packet {
    private String toUserId;
    private String message;

    public MessageRequestPacket(String toUserId, String message) {
        this.toUserId = toUserId;
        this.message = message;
    }

    @Override
    public Byte getCommand() {
        return MESSAGE_REQUEST;
    }
}
