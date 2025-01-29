package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

public abstract class Command {
    abstract public void execute(TaskList manager, Ui ui) throws AdamException;

    public boolean isExit() {
        return false;
    }
}