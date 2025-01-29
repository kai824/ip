package adam.tasks;

import adam.exceptions.AdamException;
import adam.input_handler.Parser;

import java.time.LocalDate;

/**
 * Represents a task that occurs over a period of time.
 */
public class Event extends Task {
    /** The start date of the event. */
    private LocalDate from;
    /** The end date of the event. */
    private LocalDate to;

    public Event(String description, LocalDate from, LocalDate to) throws AdamException {
        super(description);
        this.from = from;
        this.to = to;
    }
    
    /**
     * Gets the event as a String.
     * 
     * @return The event as a String.
     */
    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(),
                Parser.toOutputDate(this.from), Parser.toOutputDate(this.to));
    }

    /**
     * Gets the event as a String for logging.
     */
    @Override
    public String log() {
        // Format back into the input format
        return String.format("E | %s | %s | %s", super.log(), 
                Parser.toLogDate(this.from), Parser.toLogDate(this.to));
    }

    /**
     * Checks if the event occurs on the specified date.
     * 
     * @param date The date to check against.
     * @return True if the event occurs on the specified date.
     */
    @Override
    public boolean isOn(LocalDate date) {
        // this.from <= date <= this.to
        return (this.from.isBefore(date) || this.from.equals(date)) &&
                (this.to.isAfter(date) || this.to.equals(date));
    }
}