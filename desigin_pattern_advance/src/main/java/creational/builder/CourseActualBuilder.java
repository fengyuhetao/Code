package creational.builder;

/**
 * @author HT
 * @version V1.0
 * @package creational.builder
 * @date 2019-06-13 00:24
 */
public class CourseActualBuilder extends CourseBuilder {
    private Course course = new Course();

    @Override
    public void buildCourseName(String courseName) {
        course.setCourseName(courseName);
    }

    @Override
    public void buildCoursePPT(String buildCoursePPT) {
        course.setCoursePPT(buildCoursePPT);
    }

    @Override
    public void buildCourseVideo(String buildCourseVideo) {
        course.setCourseVideo(buildCourseVideo);
    }

    @Override
    public void buildCourseArticle(String buildCourseArticle) {
        course.setCourseArticle(buildCourseArticle);
    }

    @Override
    public void buildCourseQA(String buildCourseQA) {
        course.setCourseQA(buildCourseQA);
    }

    @Override
    public Course makeCourse() {
        return course;
    }
}
