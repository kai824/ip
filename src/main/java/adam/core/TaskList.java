package adam.core;

import adam.tasks.Task;

import java.time.LocalDate;
import java.util.ArrayList;

public class TaskList{
    private ArrayList<Task> tasks;
    private Storage storage;

    TaskList(Storage store) {
        this.storage = store;
        this.tasks = this.storage.loadLog();
    }

    public ArrayList<String> listAll() {
        ArrayList<String> outputs = new ArrayList<>();
        for (int i = 0; i < this.tasks.size(); i++) {
            outputs.add(String.format("%d. %s", i + 1, this.tasks.get(i)));
        }
        
        return outputs;
    }

    public ArrayList<String> listAllOnDate(LocalDate date) {
        ArrayList<String> outputs = new ArrayList<>();
        for (int i = 0; i < this.tasks.size(); i++) {
            Task task = this.tasks.get(i);
            if (task.isOn(date)) {
                outputs.add(String.format("%d. %s", i + 1, task));
            }
        }

        return outputs;
    }

    public void addTask(Task task) {
        this.tasks.add(task);
        this.storage.saveLog(this.tasks);
    }

    public Task deleteTask(int index) {
        // may throw IndexOutOfBoundsException
        Task deletedTask = this.tasks.remove(index);

        this.storage.saveLog(this.tasks);
        return deletedTask;
    }

    public String markDone(int index) {
        // may throw IndexOutOfBoundsException
        Task task = this.tasks.get(index);
        task.markDone();

        this.storage.saveLog(this.tasks);
        return task.toString();
    }

    public String unmarkDone(int index) {
        // may throw IndexOutOfBoundsException
        Task task = this.tasks.get(index);
        task.unmarkDone();

        this.storage.saveLog(this.tasks);
        return task.toString();
    }
}