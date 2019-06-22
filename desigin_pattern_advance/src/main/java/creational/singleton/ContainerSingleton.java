package creational.singleton;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HT
 * @version V1.0
 * @package creational.singleton
 * @date 2019-06-18 00:04
 */
public class ContainerSingleton {
    private ContainerSingleton() {}
    private static Map<String, Object> singletonMap = new HashMap<String, Object>();
    public static void putInstance(String key, Object instance) {
        if(StringUtils.isNoneBlank(key) && instance != null) {
            if(!singletonMap.containsKey(key)) {
                singletonMap.put(key, instance);
            }
        }
    }

    public static Object getInstance(String key) {
        return singletonMap.get(key);
    }
}
