import java.io.*;


public class Main {
    public static void createFiles(File dir, String tasksFile, String taskDir, String outDir, PrintWriter pw) {
        for (File group : dir.listFiles()) {
            try {
                TaskMaker tm = new TaskMaker(group.getPath(), tasksFile, taskDir);
                //tm.print(outFile);
                int dotPos = group.getName().lastIndexOf('.');
                tm.createAllVariants(outDir + "/test" + group.getName().substring(dotPos - 4, dotPos) + ".tex");
                if (pw != null) {
                    pw.println("pdflatex " +  "test" + group.getName().substring(dotPos - 4, dotPos) + ".tex");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String studentsFolder = args[0];
        String tasksFile = args[1];
        String outDir = args[2];
        String taskDir = args[3];

        File dir = new File(studentsFolder);

        new File(outDir).mkdirs();

        try {
            PrintWriter pw = new PrintWriter(new File(outDir + "/r.sh"));
            createFiles(dir, tasksFile, taskDir, outDir, pw);
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
