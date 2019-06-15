package creational.abstract_factory;

/**
 * @author HT
 * @version V1.0
 * @package creational.abstract_factory
 * @date 2019-06-12 00:24
 */
public class JavaCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new JavaVideo();
    }

    @Override
    public Article getArticle() {
        return new JavaArticle();
    }
}
