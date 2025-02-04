package adam.input_handler;

import java.util.ArrayList;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

/**
 * Represents a command to find tasks that match a given query.
 * This command will search through the task list for all tasks
 * that contain the specified query and print them to the user.
 */
public class FindCommand extends Command {
    private String query;

    FindCommand(String input) {
        super();
        this.query = input.substring(5);
    }

    public static boolean matches(String input) {
        return input.startsWith("find ");
    }

    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        ArrayList<String> outputs = manager.listMatches(this.query);
        for (String output : outputs) {
            ui.outputText(output);
        }
    }
}
