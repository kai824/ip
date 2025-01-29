package adam.input_handler;

import adam.core.TaskList;
import adam.core.Ui;
import adam.exceptions.AdamException;
import adam.exceptions.InvalidDate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Parser {
    private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    private static final DateTimeFormatter OUTPUT_DATE_FORMAT = DateTimeFormatter.ofPattern("dd MMM yyyy");

    public static LocalDate parseInputDate(String date) throws AdamException {
        try{
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
