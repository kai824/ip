package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;
import adam.tasks.Task;

/**
 * Represents a command to delete a task from the task list.
 */
public class DeleteCommand extends Command {
    /** The index of the task to delete */
    private int index;

    DeleteCommand(String input) throws AdamException {
        super();
        this.index = Integer.parseInt(input.split(" ")[1]) - 1;
    }

    /**
     * Checks if the input matches the command.
     *
     * @param input The input to check.
     * @return True if the input matches the command, false otherwise.
     */
    public static boolean isMatch(String input) {
        String[] inputParts = input.split(" ");
        return inputParts[0].equals("delete") && inputParts.length == 2;
    }

    /**
     * Deletes the task from the task list and outputs the task to the user.
     *
     * @param manager The task list to add the task to.
     * @param ui The user interface to output to.
     * @throws AdamException If an error occurs while adding the task.
     */
    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        try {
            Task task = manager.deleteTask(this.index);
            ui.outputText("OK, I've deleted this task:");
            ui.outputText("  " + task);
        } catch (IndexOutOfBoundsException e) {
            ui.outputText("Task index out of bounds!");
        }
    }
}
