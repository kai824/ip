package adam.exceptions;

public class MissingArgument extends AdamException {
    public MissingArgument(String argumentName) {
        super("Argument " + argumentName + " is missing!");
    }
}