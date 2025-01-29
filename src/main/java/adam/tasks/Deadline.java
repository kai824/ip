import java.time.LocalDate;

class Deadline extends Task {
    private LocalDate deadline;

    public Deadline(String description, LocalDate deadline) throws AdamException {
        super(description);
        this.deadline = deadline;
    }
    
    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(),
                Parser.toOutputDate(this.deadline));
    }

    @Override
    public String log() {
        // Format back into the input format
        return String.format("D | %s | %s", super.log(),
                Parser.toLogDate(this.deadline));
    }

    @Override
    public boolean isOn(LocalDate date) {
        return this.deadline.equals(date);
    }
}