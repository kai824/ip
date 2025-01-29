package adam.core;

import java.util.Scanner;

public class Ui {
    private static final String INDENTATION = "    ";
    private static final String CHATBOT_NAME = "    ";
    private Scanner scanner;

    Ui() {
        this.scanner = new Scanner(System.in);
    }

    public void greet(String name) {
        this.printSeparatingLine();
        this.outputText("Hello! I'm " + name);
        this.outputText("What can I do for you?");
        this.printSeparatingLine();
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