class InvalidDate extends AdamException {
    private static String defaultErrorMsg = "Date format is invalid!";
    
    public InvalidDate() {
        super(InvalidDate.defaultErrorMsg);
    }
}