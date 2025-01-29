package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;
import adam.tasks.Task;

public class DeleteCommand extends Command {
    private int index;

    DeleteCommand(String input) throws AdamException {
        super();
        this.index = Integer.parseInt(input.split(" ")[1]) - 1;
    }

    public static boolean matches(String input) {
        String[] inputParts = input.split(" ");
        return inputParts[0].equals("delete") && inputParts.length == 2;
    }

    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException {
        try {
            Task task = manager.deleteTask(this.index);
            ui.outputText("OK, I've deleted this task:");
            ui.outputText("  " + task);
        } catch (IndexOutOfBoundsException e) {
            ui.outputText("Task index out of bounds!");
        }
    }
}
