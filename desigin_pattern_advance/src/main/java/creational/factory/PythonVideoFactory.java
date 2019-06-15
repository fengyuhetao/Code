package creational.factory;

/**
 * @author HT
 * @version V1.0
 * @package creational.factory
 * @date 2019-06-09 19:16
 */
public class PythonVideoFactory extends VideoFactory {
    @Override
    Video getVideo() {
        return new PythonVideo();
    }
}
