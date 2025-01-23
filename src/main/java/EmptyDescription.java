class EmptyDescription extends AdamException {
    public EmptyDescription(String argumentName) {
        super("Argument " + argumentName + " is empty!");
    }
}