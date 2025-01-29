package adam.core;

import adam.exceptions.AdamException;
import adam.tasks.Task;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the storage of tasks.
 */
public class Storage {
    /** Default path of log file if none is specified */
    private static final String DEFAULT_PATH_FILE = "./data/adam_log.log";

    /** Path of log file */
    private final String LOG_PATH_FILE;

    Storage(String path) {
        this.LOG_PATH_FILE = path;
    }

    /**
     * Alternate constructor for Storage with default path.
     */
    Storage() {
        this.LOG_PATH_FILE = Storage.DEFAULT_PATH_FILE;
    }

    /**
     * Loads the log file.
     * If any error occurs, an empty ArrayList is returned.
     * 
     * @return ArrayList of tasks from log file
     */
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

    /**
     * Saves the log file.
     * 
     * @param tasks Tasks to save
     */
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
