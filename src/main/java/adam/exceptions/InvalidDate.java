package adam.exceptions;

/**
 * Represents an exception where the date format is invalid.
 */
public class InvalidDate extends AdamException {
    private static String defaultErrorMsg = "Date format is invalid!";

    public InvalidDate() {
        super(InvalidDate.defaultErrorMsg);
    }
}
