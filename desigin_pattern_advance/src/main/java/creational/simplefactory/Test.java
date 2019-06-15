package creational.simplefactory;

/**
 * @author HT
 * @version V1.0
 * @package creational.simplefactory
 * @date 2019-06-08 22:44
 */
public class Test {
    public static void main(String[] args) {
        VideoFactory videoFactory = new VideoFactory();
        Video video = videoFactory.getVideoByReflection(JavaVideo.class);
        if(video == null) {
            System.out.println("没找到");
        }
        video.produce();
    }
}
