package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

public class ByeCommand extends Command {
    public static boolean matches(String input) {
        return input.equals("bye");
    }

    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        ui.outputText("Bye. Hope to see you again soon!");
    }

    @Override
    public boolean isExit() {
        return true;
    }
}