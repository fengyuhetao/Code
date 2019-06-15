package creational.simplefactory;

/**
 * @author HT
 * @version V1.0
 * @package creational.simplefactory
 * @date 2019-06-08 22:46
 */
class VideoFactory {
    Video getVideo(String type) {
         if("java".equalsIgnoreCase(type)) {
             return new JavaVideo();
         } else if("python".equalsIgnoreCase(type)) {
             return new PythonVideo();
         } else {
             return null;
         }
    }

    Video getVideoByReflection(Class clazz) {
        Video video = null;
        try {
            video = (Video) Class.forName(clazz.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return video;
    }
}
