import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

class Parser {
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
}