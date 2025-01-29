import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Storage {
    private static final String DEFAULT_PATH_FILE = "./data/adam_log.log";
    private final String LOG_PATH_FILE;

    Storage(String path) {
        this.LOG_PATH_FILE = path;
    }

    Storage() {
        this.LOG_PATH_FILE = Storage.DEFAULT_PATH_FILE;
    }

    public ArrayList<Task> loadLog() {
        ArrayList<Task> tasks = new ArrayList<>();
        try {
            File file = new File(this.LOG_PATH_FILE);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = Task.fromLog(line);
                tasks.add(task);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            // No previous tasklist: do nothing
        } catch (AdamException e) {
            System.out.println("Error loading task list from file: " + e + ". Ignoring file.");
            tasks = new ArrayList<>();
        }
        return tasks;
    }

    public void saveLog(ArrayList<Task> tasks) {
        try {
            File file = new File(this.LOG_PATH_FILE);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(this.LOG_PATH_FILE);
            for (Task task : tasks) {
                writer.write(task.log() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving task list to file: " + e);
        }
    }
}