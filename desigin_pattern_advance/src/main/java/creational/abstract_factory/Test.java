package creational.abstract_factory;

/**
 * @author HT
 * @version V1.0
 * @package creational.abstract_factory
 * @date 2019-06-12 00:26
 */
public class Test {
    public static void main(String[] args) {
        CourseFactory javaCourseFactory = new JavaCourseFactory();
        javaCourseFactory.getArticle().produce();
        javaCourseFactory.getVideo().produce();
    }
}
