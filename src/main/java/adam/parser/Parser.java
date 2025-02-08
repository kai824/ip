package adam.parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import adam.command.AddCommand;
import adam.command.ByeCommand;
import adam.command.Command;
import adam.command.DeleteCommand;
import adam.command.DoneCommand;
import adam.command.FindCommand;
import adam.command.ListCommand;
import adam.command.ListOnCommand;
import adam.command.UnmarkCommand;
import adam.exceptions.AdamException;
import adam.exceptions.InvalidDate;

/**
 * Static methods to parse user input and create commands.
 */
public class Parser {
    /** String DateTime format for date to be read */
    public static final String DATE_FORMAT_STRING = "dd-MM-yyyy";

    /** DateTime Format for dates to be read and output */
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern(DATE_FORMAT_STRING);
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
    public static String formatOutputDate(LocalDate date) {
        return date.format(Parser.OUTPUT_DATE_FORMAT);
    }

    /**
     * Converts a LocalDate to a string in the format dd-MM-yyyy.
     *
     * @param date The date to convert.
     * @return The date as a string in the format dd-MM-yyyy.
     */
    public static String formatLogDate(LocalDate date) {
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
        } else if (FindCommand.isMatch(input)) {
            return new FindCommand(input);
        } else {
            // throws AdamException if invalid input
            return new AddCommand(input);
        }
    }
}
