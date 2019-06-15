package creational.builder;

/**
 * @author HT
 * @version V1.0
 * @package creational.builder
 * @date 2019-06-13 00:21
 */
public abstract class CourseBuilder {
    public abstract void buildCourseName(String courseName);

    public abstract void buildCoursePPT(String buildCoursePPT);

    public abstract void buildCourseVideo(String buildCourseVideo);

    public abstract void buildCourseArticle(String buildCourseArticle);

    public abstract void buildCourseQA(String buildCourseQA);

    public abstract Course makeCourse();
}
