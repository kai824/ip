class Event extends Task {
    private String from;
    private String to;

    public Event(String description, String from, String To) throws AdamException {
        super(description);
        this.from = from;
        this.to = to;
    }
    
    @Override
    public String toString() {
        return String.format("[E]%s (from: %s to: %s)", super.toString(),
            this.from, this.to);
    }
}