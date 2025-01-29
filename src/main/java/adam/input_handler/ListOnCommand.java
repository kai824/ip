package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListOnCommand extends Command {
    private LocalDate date;

    ListOnCommand(String input) throws AdamException {
        super();
        this.date = Parser.parseInputDate(input.split(" ")[1]);
    }

    public static boolean matches(String input) {
        String[] inputParts = input.split(" ");
        return inputParts[0].equals("listOn") && inputParts.length == 2;
    }

    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        ArrayList<String> outputs = manager.listAllOnDate(this.date);
        for (String output : outputs) {
            ui.outputText(output);
        }
    }
}
