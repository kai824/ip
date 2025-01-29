import java.util.ArrayList;

class TaskManager {
    private ArrayList<Task> tasks;

    TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public ArrayList<String> listAll() {
        ArrayList<String> outputs = new ArrayList<>();
        for (int i = 0; i < this.tasks.size(); i++) {
            outputs.add(String.format("%d. %s", i + 1, this.tasks.get(i)));
        }
        
        return outputs;
    }
    
    Task get(int index) {
        // may throw IndexOutOfBoundsException
        return this.tasks.get(index);
    }

    void addTask(Task task) {
        this.tasks.add(task);
    }

    Task deleteTask(int index) {
        // may throw IndexOutOfBoundsException
        return this.tasks.remove(index);
    }
}