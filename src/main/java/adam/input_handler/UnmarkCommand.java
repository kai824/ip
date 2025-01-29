package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

import java.util.ArrayList;

/**
 * Represents a command to unmark a task as done.
 */
public class UnmarkCommand extends Command {
    /** The index of the task to unmark */
    private int index;

    UnmarkCommand(String input) throws AdamException{
        super();
        this.index = Integer.parseInt(input.split(" ")[1]) - 1;
    }

    /**
     * Checks if the input matches the command.
     * 
     * @param input The input to check.
     * @return True if the input matches the command, false otherwise.
     */
    public static boolean matches(String input) {
        String[] inputParts = input.split(" ");
        return inputParts[0].equals("unmark") && inputParts.length == 2;
    }

    /**
     * Unmarks the task as done and outputs the task to the user.
     * 
     * @param manager The task list to add the task to.
     * @param ui The user interface to output to.
     * @throws AdamException If an error occurs while adding the task.
     */
    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException{
        try {
            String taskText = manager.unmarkDone(this.index);
            ui.outputText("OK, I've marked this task as not done yet:");
            ui.outputText("  " + taskText);
        } catch (IndexOutOfBoundsException e) {
            ui.outputText("Task index out of bounds!");
        }
    }
}