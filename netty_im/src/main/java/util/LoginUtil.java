package util;

import TwoWayCommunication.Attributes;
import io.netty.channel.Channel;
import io.netty.util.Attribute;

/**
 * @author HT
 * @version V1.0
 * @package util
 * @date 2019-05-13 22:35
 */
public class LoginUtil {
    public static void markAsLogin(Channel channel) {
        channel.attr(Attributes.LOGIN).set(true);
    }

    public static boolean hasLogin(Channel channel) {
        Attribute<Boolean> loginAttr = channel.attr(Attributes.LOGIN);

        return loginAttr.get() != null;
    }
}
