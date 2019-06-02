package Protocol.packet;

import lombok.Data;

import static Protocol.command.Command.LOGIN_REQUEST;

/**
 * @author HT
 * @version V1.0
 * @package Protocol
 * @date 2019-05-13 20:00
 */
@Data
public class LoginRequestPacket extends Packet {
    private Integer userId;

    private String username;

    private String password;

    @Override
    public Byte getCommand() {
        return LOGIN_REQUEST;
    }
}
