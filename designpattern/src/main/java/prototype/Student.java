package prototype;

/**
 * @author HT
 * @version V1.0
 * @package prototype
 * @date 2019-05-08 19:15
 */
public class Student implements Cloneable {
    private String name;

    private int age;

    private Professor professor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", professor=" + professor + "]";
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student newStudent = (Student) super.clone();
        newStudent.professor = (Professor) professor.clone();
        return newStudent;
    }
}

