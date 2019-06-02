package Protocol.packet;

import lombok.Data;

/**
 * @author HT
 * @version V1.0
 * @package Protocol
 * @date 2019-05-13 19:58
 */
@Data
public abstract class Packet {
    /**
     * 协议版本
     */
    private Byte version = 1;

    /**
     * 指令
     */
    public abstract Byte getCommand();
}
