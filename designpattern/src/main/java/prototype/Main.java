package prototype;

/**
 * @author HT
 * @version V1.0
 * @package prototype
 * @date 2019-05-08 19:18
 */
public class Main {
    public static void main(String[] args) {
        Professor professor1 = new Professor();
        professor1.setName("Professor1");
        professor1.setAge(18);

        Student student = new Student();
        student.setName("xiao ming");
        student.setAge(18);
        student.setProfessor(professor1);

        System.out.println(student);

        try {
            Student student2 = (Student) student.clone();
            student2.setName("xiao hong");
            Professor professor2 = new Professor();
            professor2.setName("professor 2");
            professor2.setAge(29);
            student2.setProfessor(professor2);
            System.out.println(student);
            System.out.println(student2);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
