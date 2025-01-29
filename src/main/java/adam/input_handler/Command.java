package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

/**
 * Represents a command that can be executed by the user.
 */
public abstract class Command {
    abstract public void execute(TaskList manager, Ui ui) throws AdamException;

    /**
     * Checks if the command is an exit command.
     * 
     * @return True if the command is an exit command, false otherwise.
     */
    public boolean isExit() {
        return false;
    }
}
