import java.time.LocalDate;

class Event extends Task {
    private LocalDate from;
    private LocalDate to;

    public Event(String description, LocalDate from, LocalDate to) throws AdamException {
        super(description);
        this.from = from;
        this.to = to;
    }
    
    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(),
                Parser.toOutputDate(this.from), Parser.toOutputDate(this.to));
    }

    @Override
    public String log() {
        // Format back into the input format
        return String.format("E | %s | %s | %s", super.log(), 
                Parser.toLogDate(this.from), Parser.toLogDate(this.to));
    }

    @Override
    public boolean isOn(LocalDate date) {
        // this.from <= date <= this.to
        return (this.from.isBefore(date) || this.from.equals(date)) &&
                (this.to.isAfter(date) || this.to.equals(date));
    }
}