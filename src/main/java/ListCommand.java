import java.util.ArrayList;

class ListCommand extends Command {
    public static boolean matches(String input) {
        return input.equals("list");
    }

    @Override
    public void execute(TaskList manager, Ui ui) throws AdamException{
        ArrayList<String> outputs = manager.listAll();
        for (String output : outputs) {
            ui.outputText(output);
        }
    }
}