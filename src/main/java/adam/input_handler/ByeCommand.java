package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

/**
 * Represents a command to exit the program.
 */
public class ByeCommand extends Command {
    /**
     * Checks if the input matches the command.
     * 
     * @param input The input to check.
     * @return True if the input matches the command, false otherwise.
     */
    public static boolean matches(String input) {
        return input.equals("bye");
    }

    /**
     * Outputs a goodbye message to the user.
     * 
     * @param manager The task list to add the task to.
     * @param ui The user interface to output to.
     * @throws AdamException If an error occurs while adding the task.
     */
    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        ui.outputText("Bye. Hope to see you again soon!");
    }

    /**
     * Checks if it is an exit command.
     * 
     * @return True as Bye is an exit command.
     */
    @Override
    public boolean isExit() {
        return true;
    }
}