class ToDo extends Task {
    public ToDo(String description) throws AdamException {
        super(description);
    }
    
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}