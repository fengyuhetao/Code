package creational.builder;

/**
 * @author HT
 * @version V1.0
 * @package creational.builder
 * @date 2019-06-13 00:27
 */
public class Coach {
    private CourseBuilder courseBuilder;

    public void setCourseBuilder(CourseBuilder courseBuilder) {
        this.courseBuilder = courseBuilder;
    }

    public Course makeCourse(String courseName, String courseVideo, String coursePPT, String courseArticle, String courseQA) {
        this.courseBuilder.buildCourseName(courseName);
        this.courseBuilder.buildCourseArticle(courseArticle);
        this.courseBuilder.buildCoursePPT(coursePPT);
        this.courseBuilder.buildCourseQA(courseQA);
        this.courseBuilder.buildCourseVideo(courseVideo);
        return this.courseBuilder.makeCourse();
    }
}
