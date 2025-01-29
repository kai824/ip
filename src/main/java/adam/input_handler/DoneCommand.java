package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;

public class DoneCommand extends Command {
    private int index;

    DoneCommand(String input) throws AdamException {
        super();
        this.index = Integer.parseInt(input.split(" ")[1]) - 1;
    }

    public static boolean isMatch(String input) {
        String[] inputParts = input.split(" ");
        return inputParts[0].equals("mark") && inputParts.length == 2;
    }

    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        try {
            String taskText = manager.markDone(this.index);
            ui.outputText("Nice! I've marked this task as done:");
            ui.outputText("  " + taskText);
        } catch (IndexOutOfBoundsException e) {
            ui.outputText("Task index out of bounds!");
        }
    }
}
