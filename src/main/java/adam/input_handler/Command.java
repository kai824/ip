abstract class Command {
    abstract public void execute(TaskList manager, Ui ui) throws AdamException;

    public boolean isExit() {
        return false;
    }
}