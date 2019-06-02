package Protocol.packet;

import lombok.Data;

import static Protocol.command.Command.LOGIN_RESPONSE;

/**
 * @author HT
 * @version V1.0
 * @package Protocol
 * @date 2019-05-13 21:47
 */
@Data
public class LoginResponsePacket extends Packet {
    private boolean success;

    private String reason;

    private String userId;

    private String username;

    @Override
    public Byte getCommand() {
        return LOGIN_RESPONSE;
    }
}
