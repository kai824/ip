package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

import java.util.ArrayList;

public class ListCommand extends Command {
    public static boolean matches(String input) {
        return input.equals("list");
    }

    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        ArrayList<String> outputs = manager.listAll();
        for (String output : outputs) {
            ui.outputText(output);
        }
    }
}
