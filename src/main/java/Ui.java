import java.util.Scanner;

class Ui {
    private static final String INDENTATION = "    ";
    private Scanner scanner;

    Ui() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        return this.scanner.nextLine();
    }

    public void outputText(String text) {
        System.out.println(INDENTATION + " " + text);
    }

    public void printSeparatingLine() {
        System.out.println(INDENTATION + "____________________________________________________________");
    }
}