package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

import java.util.ArrayList;

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