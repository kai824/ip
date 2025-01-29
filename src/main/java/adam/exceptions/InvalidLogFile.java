class InvalidLogFile extends AdamException {
    private static String defaultErrorMsg = "Log file format is invalid!";
    
    public InvalidLogFile() {
        super(InvalidLogFile.defaultErrorMsg);
    }
}