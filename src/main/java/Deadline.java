class Deadline extends Task {
    private String deadline;

    public Deadline(String description, String deadline) throws AdamException {
        super(description);
        this.deadline = deadline;
    }
    
    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), this.deadline);
    }

    @Override
    public String log() {
        // Assuming that the deadline does not contain the delimiter "|" character
        return String.format("D | %s | %s", super.log(), this.deadline);
    }
}