package creational.factory;

/**
 * @author HT
 * @version V1.0
 * @package creational.simplefactory
 * @date 2019-06-08 22:43
 */
public class PythonVideo extends Video {
    @Override
    void produce() {
        System.out.println("录制python视频");
    }
}
