package adam.input_handler;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import adam.exceptions.AdamException;
import adam.exceptions.InvalidDate;

/**
 * Static methods to parse user input and create commands.
 */
public class Parser {
    /** DateTime Format for dates to be read and output */
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter OUTPUT_DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd MMM yyyy");

    /**
     * Parses the input string into a LocalDate object using the defined date format.
     *
     * @param date The input string representing the date, expected in the format "dd-MM-yyyy".
     * @return A LocalDate object parsed from the input date string.
     * @throws AdamException If the input string does not match the expected date format.
     */
    public static LocalDate parseInputDate(String date) throws AdamException {
        try {
            return LocalDate.parse(date, Parser.DATE_FORMAT);
        } catch (DateTimeParseException e) {
            throw new InvalidDate();
        }
    }

    /**
     * Converts a LocalDate to a string in the format dd MMM yyyy.
     *
     * @param date The date to convert.
     * @return The date as a string in the format dd MMM yyyy.
     */
    public static String toOutputDate(LocalDate date) {
        return date.format(Parser.OUTPUT_DATE_FORMAT);
    }

    /**
     * Converts a LocalDate to a string in the format dd-MM-yyyy.
     *
     * @param date The date to convert.
     * @return The date as a string in the format dd-MM-yyyy.
     */
    public static String toLogDate(LocalDate date) {
        return date.format(Parser.DATE_FORMAT);
    }

    /**
     * Parses the input and returns the corresponding command.
     *
     * @param input The input to parse.
     * @return The corresponding command.
     * @throws AdamException If the input is invalid.
     */
    public static Command parseInput(String input) throws AdamException {
        if (ByeCommand.isMatch(input)) {
            return new ByeCommand();
        } else if (ListCommand.isMatch(input)) {
            return new ListCommand();
        } else if (ListOnCommand.isMatch(input)) {
            return new ListOnCommand(input);
        } else if (DoneCommand.isMatch(input)) {
            return new DoneCommand(input);
        } else if (UnmarkCommand.isMatch(input)) {
            return new UnmarkCommand(input);
        } else if (DeleteCommand.isMatch(input)) {
            return new DeleteCommand(input);
        } else if (FindCommand.matches(input)) {
            return new FindCommand(input);
        } else {
            // throws AdamException if invalid input
            return new AddCommand(input);
        }
    }
}
