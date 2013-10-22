/**
 * User: Arina Buzdalova
 * Date: 22.10.13
 */
public class Student {
    private String name;
    private String task;

    public Student(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public String toString() {
        return name + " " + task;
    }
}
