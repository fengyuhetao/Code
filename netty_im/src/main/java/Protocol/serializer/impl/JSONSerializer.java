package Protocol.serializer.impl;


import Protocol.serializer.SerializerAlgorithm;
import Protocol.serializer.Serializer;
import com.alibaba.fastjson.JSON;

/**
 * @author HT
 * @version V1.0
 * @package Protocol
 * @date 2019-05-13 20:50
 */
public class JSONSerializer implements Serializer {
    @Override
    public byte getSerializerAlgorithm() {
        return SerializerAlgorithm.JSON;
    }

    @Override
    public byte[] serialize(Object object) {
        return JSON.toJSONBytes(object);
    }

    @Override
    public <T> T deserialize(Class<T> clazz, byte[] bytes) {
        return JSON.parseObject(bytes, clazz);
    }
}
