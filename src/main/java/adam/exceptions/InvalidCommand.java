package adam.exceptions;

/**
 * Represents an exception where the command is not recognised.
 */
public class InvalidCommand extends AdamException {
    private static String defaultErrorMsg =
            "Command not recognised! Valid commands are: list, todo, deadline, event, bye";
    
    public InvalidCommand() {
        super(InvalidCommand.defaultErrorMsg);
    }
}