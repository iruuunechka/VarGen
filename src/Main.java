import java.io.*;
import java.util.*;


public class Main {

    public static class Student {
        private String name;
        private String task;

        private Student(String name, String task) {
            this.name = name;
            this.task = task;
        }

        @Override
        public String toString() {
            return name + " " + task;
        }
    }

    private static List<Student> createTable(String studentsFile, String tasksFile) throws IOException {
        List<Student> table = new ArrayList<>();
        BufferedReader st = new BufferedReader(new FileReader(new File(studentsFile)));
        BufferedReader tf = new BufferedReader(new FileReader(new File(tasksFile)));
        List<Integer> taskCou = new ArrayList<>();
        String s;
        while (! ((s = tf.readLine()) == null)) {
            taskCou.add(Integer.valueOf(s));
        }
        Random rand= new Random();
        while (!((s = st.readLine()) == null)) {
            String res = "";
            for (int i = 0; i < taskCou.size(); ++i) {
                res += String.valueOf(i + 1) + (char)('a' + rand.nextInt(taskCou.get(i))) + " ";
            }
            table.add(new Student(s, res));
        }
        return table;
    }

    public static void print(String outFile, List<Student> table) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(outFile));
        for (Student aTable : table) {
            pw.println(aTable.toString());
            pw.println();
            pw.println();
            pw.println();
            pw.println();
        }
        pw.flush();
    }

    public static void main(String[] args) {
        String studentsFile = args[0];
        String tasksFile = args[1];
        String outFile = args[2];
        try {
            print(outFile, createTable(studentsFile, tasksFile));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
