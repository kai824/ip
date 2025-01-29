class Ui {
    private static final String INDENTATION = "    ";

    public void outputText(String text) {
        System.out.println(INDENTATION + " " + text);
    }

    public void printSeparatingLine() {
        System.out.println(INDENTATION + "____________________________________________________________");
    }
}