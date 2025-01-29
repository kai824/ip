package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;
import adam.exceptions.InvalidDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

/**
 * Static methods to parse user input and create commands.
 */
public class Parser {
    /** DateTime Format for dates to be read and output */
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter OUTPUT_DATE_FORMAT = DateTimeFormatter.ofPattern("dd MMM yyyy");

    public static LocalDate parseInputDate(String date) throws AdamException {
        try{
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
        if(ByeCommand.matches(input)) {
            return new ByeCommand();
        } else if(ListCommand.matches(input)) {
            return new ListCommand();
        } else if(ListOnCommand.matches(input)) {
            return new ListOnCommand(input);
        } else if(DoneCommand.matches(input)) {
            return new DoneCommand(input);
        } else if(UnmarkCommand.matches(input)) {
            return new UnmarkCommand(input);
        } else if(DeleteCommand.matches(input)) {
            return new DeleteCommand(input);
        } else {
            // throws AdamException if invalid input
            return new AddCommand(input);
        }
    }
}
