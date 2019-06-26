package structural.composite;

/**
 * @author HT
 * @version V1.0
 * @package structural.composite
 * @date 2019-06-25 23:57
 */
public class Test {
    public static void main(String[] args) {
        CatalogComponent linuxCourse = new Course("linux课程", 11);
        CatalogComponent windowsCourse = new Course("Windows课程", 12);

        CatalogComponent javaCourseCatalog = new CourseCatalog("java课程目录");

        CatalogComponent mmallCourse = new Course("Java电商一期", 15);
        CatalogComponent mmallCourse1 = new Course("Java电商二期", 15);

        javaCourseCatalog.add(mmallCourse);
        javaCourseCatalog.add(mmallCourse1);

        CatalogComponent imoocMainCourseCatalog = new CourseCatalog("慕课网主目录");
        imoocMainCourseCatalog.add(linuxCourse);
        imoocMainCourseCatalog.add(windowsCourse);
        imoocMainCourseCatalog.add(javaCourseCatalog);

        imoocMainCourseCatalog.print();

    }
}
