package adam.core;

import java.util.Scanner;

/**
 * Represents the user interface of the chatbot.
 */
public class Ui {
    /** Indentation for chatbot messages */
    private static final String INDENTATION = "    ";
    private Scanner scanner;

    Ui() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Greets the user.
     * 
     * @param name Name of the chatbot.
     */
    public void greet(String name) {
        this.printSeparatingLine();
        this.outputText("Hello! I'm " + name);
        this.outputText("What can I do for you?");
        this.printSeparatingLine();
    }

    /**
     * Gets user input.
     * 
     * @return The next line of user input.
     */
    public String getUserInput() {
        return this.scanner.nextLine();
    }

    /**
     * Outputs text to the user.
     * 
     * @param text Text to output.
     */
    public void outputText(String text) {
        System.out.println(INDENTATION + " " + text);
    }

    /**
     * Prints a separating line.
     */
    public void printSeparatingLine() {
        System.out.println(
                INDENTATION + "____________________________________________________________");
    }
}
