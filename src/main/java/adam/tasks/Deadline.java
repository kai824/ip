package adam.tasks;

import adam.exceptions.AdamException;
import adam.input_handler.Parser;

import java.time.LocalDate;

/**
 * Represents a task with a deadline.
 */
public class Deadline extends Task {
    /** The deadline of the task. */
    private LocalDate deadline;

    public Deadline(String description, LocalDate deadline) throws AdamException {
        super(description);
        this.deadline = deadline;
    }
    
    /**
     * Gets the deadline of the task as a String.
     * 
     * @return The deadline of the task.
     */
    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(),
                Parser.toOutputDate(this.deadline));
    }

    /**
     * Gets the deadline of the task as a String for logging.
     */
    @Override
    public String log() {
        // Format back into the input format
        return String.format("D | %s | %s", super.log(),
                Parser.toLogDate(this.deadline));
    }

    /**
     * Checks if the task is due on the specified date.
     * 
     * @param date The date to check against.
     * @return True if the task is due on the specified date.
     */
    @Override
    public boolean isOn(LocalDate date) {
        return this.deadline.equals(date);
    }
}