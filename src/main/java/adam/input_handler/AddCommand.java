package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;
import adam.tasks.Task;

public class AddCommand extends Command {
    private Task newTask;

    AddCommand(String input) throws AdamException {
        super();
        this.newTask = Task.of(input);
    }

    public static boolean matches(String input) {
        try {
            Task.of(input);
            return true;
        } catch (AdamException e) {
            return false;
        }
    }

    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        manager.addTask(this.newTask);
        ui.outputText("Got it. I've added this task:");
        ui.outputText(" " + this.newTask);
    }
}
