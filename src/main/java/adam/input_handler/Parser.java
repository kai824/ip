package adam.input_handler;

import adam.exceptions.AdamException;
import adam.exceptions.InvalidDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Parser {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter OUTPUT_DATE_FORMAT =
            DateTimeFormatter.ofPattern("dd MMM yyyy");

    public static LocalDate parseInputDate(String date) throws AdamException {
        try {
            return LocalDate.parse(date, Parser.DATE_FORMAT);
        } catch (DateTimeParseException e) {
            throw new InvalidDate();
        }
    }

    public static String toOutputDate(LocalDate date) {
        return date.format(Parser.OUTPUT_DATE_FORMAT);
    }

    public static String toLogDate(LocalDate date) {
        return date.format(Parser.DATE_FORMAT);
    }

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
        } else if(FindCommand.matches(input)) {
            return new FindCommand(input);
        } else {
            // throws AdamException if invalid input
            return new AddCommand(input);
        }
    }
}
