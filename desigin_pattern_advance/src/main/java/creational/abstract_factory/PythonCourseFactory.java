package creational.abstract_factory;

/**
 * @author HT
 * @version V1.0
 * @package creational.abstract_factory
 * @date 2019-06-12 00:28
 */
public class PythonCourseFactory implements CourseFactory {
    @Override
    public Video getVideo() {
        return new PythonVideo();
    }

    @Override
    public Article getArticle() {
        return new PythonArticle();
    }
}
