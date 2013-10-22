import java.io.*;
import java.nio.file.Files;
import java.util.*;

/**
 * User: Arina Buzdalova
 * Date: 22.10.13
 */
public class TaskMaker {
    public TaskMaker(String studentsFile, String tasksFile, String taskDir) throws IOException {
        taskNames = getTaskNames(tasksFile);
        studentTable = createTable(studentsFile, tasksFile);
        taskMap = readTasks(taskDir);
    }

    private Map<String, byte[]> taskMap;
    private List<List<String>> taskNames;
    private List<Student> studentTable;

    private List<List<String>> getTaskNames(String tasksFile) throws IOException {
        List<List<String>> tasks = new ArrayList<>();
        BufferedReader tf = new BufferedReader(new FileReader(new File(tasksFile)));
        String s;
        int taskNum = 0;
        while (! ((s = tf.readLine()) == null)) {
            tasks.add(new ArrayList<String>());
            for (int i = 0; i < Integer.valueOf(s); ++i) {
                tasks.get(taskNum).add(String.valueOf(taskNum + 1) + (char)('a' + i));
            }
            taskNum++;
        }
        return tasks;
    }

    public List<Student> createTable(String studentsFile, String tasksFile) throws IOException {
        List<Student> table = new ArrayList<>();
        getTaskNames(tasksFile);
        BufferedReader st = new BufferedReader(new FileReader(new File(studentsFile)));
        Random rand= new Random();
        String s;
        while (!((s = st.readLine()) == null)) {
            String res = "";
            for (List<String> taskName : taskNames) {
                res += taskName.get(rand.nextInt(taskName.size())) + " ";
            }
            table.add(new Student(s, res));
        }
        return table;
    }

    private Map<String, byte[]> readTasks(String tasksDir) throws IOException {
        Map<String, byte[]> tasks = new HashMap<>();
        File dir = new File(tasksDir);
        for (File task : dir.listFiles()) {
            tasks.put(task.getName().split("\\.")[0], Files.readAllBytes(task.toPath()));
        }
        return tasks;
    }

    public void print(String outFile) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(outFile));
        for (Student aTable : studentTable) {
            pw.println(aTable.toString());
            pw.println();
            pw.println();
            pw.println();
            pw.println();
        }
        pw.flush();
    }
}
