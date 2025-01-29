package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

public class UnmarkCommand extends Command {
    private int index;

    UnmarkCommand(String input) throws AdamException {
        super();
        this.index = Integer.parseInt(input.split(" ")[1]) - 1;
    }

    public static boolean isMatch(String input) {
        String[] inputParts = input.split(" ");
        return inputParts[0].equals("unmark") && inputParts.length == 2;
    }

    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        try {
            String taskText = manager.unmarkDone(this.index);
            ui.outputText("OK, I've marked this task as not done yet:");
            ui.outputText("  " + taskText);
        } catch (IndexOutOfBoundsException e) {
            ui.outputText("Task index out of bounds!");
        }
    }
}
