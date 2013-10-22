import java.io.*;


public class Main {



    public static void main(String[] args) {
        String studentsFile = args[0];
        String tasksFile = args[1];
        String outFile = args[2];
        String taskDir = args[3];
        try {
            TaskMaker tm = new TaskMaker(studentsFile, tasksFile, taskDir);
            tm.print(outFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
