package adam.parser;

import java.util.ArrayList;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

/**
 * Represents a command to list all tasks in the task list.
 */
public class ListCommand extends Command {
    /**
     * Checks if the input matches the command.
     *
     * @param input The input to check.
     * @return True if the input matches the command, false otherwise.
     */
    public static boolean isMatch(String input) {
        return input.equals("list");
    }

    /**
     * Lists all tasks in the task list.
     *
     * @param manager The task list to add the task to.
     * @param ui The user interface to output to.
     * @throws AdamException If an error occurs while adding the task.
     */
    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        ArrayList<String> outputs = manager.listAll();
        for (String output : outputs) {
            ui.outputText(output);
        }
    }
}
