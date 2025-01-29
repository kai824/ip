package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Represents a command to list all tasks on a specific date.
 */
public class ListOnCommand extends Command {
    /** The date to list tasks on */
    private LocalDate date;

    ListOnCommand(String input) throws AdamException {
        super();
        this.date = Parser.parseInputDate(input.split(" ")[1]);
    }

    /**
     * Checks if the input matches the command.
     * 
     * @param input The input to check.
     * @return True if the input matches the command, false otherwise.
     */
    public static boolean isMatch(String input) {
        String[] inputParts = input.split(" ");
        return inputParts[0].equals("listOn") && inputParts.length == 2;
    }

    /**
     * Lists all tasks on the specified date.
     * 
     * @param manager The task list to add the task to.
     * @param ui The user interface to output to.
     * @throws AdamException If an error occurs while adding the task.
     */
    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        ArrayList<String> outputs = manager.listAllOnDate(this.date);
        for (String output : outputs) {
            ui.outputText(output);
        }
    }
}
