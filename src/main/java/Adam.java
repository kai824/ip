import java.util.Scanner;

public class Adam {
    private static void printSeparatingLine() {
        System.out.println("    ____________________________________________________________");
    }

    private static void outputText(String text) {
        System.out.println("     " + text);
    }

    public static void main(String[] args) {
        String CHATBOT_NAME = "Adam";
        printSeparatingLine();
        outputText("Hello! I'm " + CHATBOT_NAME);
        outputText("What can I do for you?");
        printSeparatingLine();

        Scanner sc = new Scanner(System.in);
        boolean exited = false;

        while(!exited) {
            String userInput = sc.nextLine();
            if (userInput.equals("bye")) {
                exited = true;
            } else {
                printSeparatingLine();
                outputText(userInput);
                printSeparatingLine();
            }
        }

        printSeparatingLine();
        outputText("Bye. Hope to see you again soon!");
        printSeparatingLine();
    }
}
