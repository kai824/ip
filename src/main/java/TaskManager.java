import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class TaskManager {
    private ArrayList<Task> tasks;
    private static final String LOG_PATH_FILE = "./data/adam_log.log";

    TaskManager() {
        this.tasks = new ArrayList<>();
        try {
            File file = new File(this.LOG_PATH_FILE);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Task task = Task.fromLog(line);
                this.tasks.add(task);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            // No previous tasklist: do nothing
        } catch (AdamException e) {
            System.out.println("Error loading task list from file: " + e + ". Ignoring file.");
            this.tasks = new ArrayList<>();
        }
    }

    public ArrayList<String> listAll() {
        ArrayList<String> outputs = new ArrayList<>();
        for (int i = 0; i < this.tasks.size(); i++) {
            outputs.add(String.format("%d. %s", i + 1, this.tasks.get(i)));
        }
        
        return outputs;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        this.saveLog();
    }

    public Task deleteTask(int index) {
        // may throw IndexOutOfBoundsException
        Task deletedTask = this.tasks.remove(index);

        this.saveLog();
        return deletedTask;
    }

    public String markDone(int index) {
        // may throw IndexOutOfBoundsException
        Task task = this.tasks.get(index);
        task.markDone();

        this.saveLog();
        return task.toString();
    }

    public String unmarkDone(int index) {
        // may throw IndexOutOfBoundsException
        Task task = this.tasks.get(index);
        task.unmarkDone();

        this.saveLog();
        return task.toString();
    }

    private void saveLog() {
        try {
            File file = new File(this.LOG_PATH_FILE);
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }

            FileWriter writer = new FileWriter(this.LOG_PATH_FILE);
            for (Task task : this.tasks) {
                writer.write(task.log() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Error saving task list to file: " + e);
        }
    }
}