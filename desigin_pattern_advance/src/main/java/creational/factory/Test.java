package creational.factory;

import creational.simplefactory.JavaVideo;

/**
 * @author HT
 * @version V1.0
 * @package creational.simplefactory
 * @date 2019-06-08 22:44
 */
public class Test {
    public static void main(String[] args) {
        VideoFactory videoFactory = new JavaVideoFactory();
        if(videoFactory == null) {
            return ;
        }
        Video video = videoFactory.getVideo();
        if(video == null) {
            return ;
        }
        video.produce();


        videoFactory = new PythonVideoFactory();
        if(videoFactory == null) {
            return ;
        }
        video = videoFactory.getVideo();
        if(video == null) {
            return ;
        }
        video.produce();

    }
}
