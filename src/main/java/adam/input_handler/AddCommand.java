package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;
import adam.tasks.Task;

/**
 * Represents a command to add a task to the task list.
 */
public class AddCommand extends Command {
    /** The new task to add */
    private Task newTask;

    AddCommand(String input) throws AdamException {
        super();
        this.newTask = Task.of(input);
    }

    /**
     * Checks if the input matches the command.
     * 
     * @param input The input to check.
     * @return True if the input matches the command, false otherwise.
     */
    public static boolean isMatch(String input) {
        try {
            Task.of(input);
            return true;
        } catch (AdamException e) {
            return false;
        }
    }

    /**
     * Adds the new task to the task list and outputs the task to the user.
     * 
     * @param manager The task list to add the task to.
     * @param ui The user interface to output to.
     * @throws AdamException If an error occurs while adding the task.
     */
    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        manager.addTask(this.newTask);
        ui.outputText("Got it. I've added this task:");
        ui.outputText(" " + this.newTask);
    }
}
