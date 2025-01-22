import java.util.ArrayList;
import java.util.Scanner;

public class Adam {
    private static ArrayList<String> history;

    private static void printSeparatingLine() {
        System.out.println("    ____________________________________________________________");
    }

    private static void outputText(String text) {
        System.out.println("     " + text);
    }

    private static void listAll() {
        for (int i = 0; i < Adam.history.size(); i++) {
            outputText(String.format("%d. %s", i + 1, Adam.history.get(i)));
        }
    }

    private static void addNew(String text) {
        Adam.history.add(text);
        outputText("added: " + text);
    }

    public static void main(String[] args) {
        String CHATBOT_NAME = "Adam";
        printSeparatingLine();
        outputText("Hello! I'm " + CHATBOT_NAME);
        outputText("What can I do for you?");
        printSeparatingLine();

        Scanner sc = new Scanner(System.in);
        history = new ArrayList<String>();

        while(true) {
            String userInput = sc.nextLine();
            if (userInput.equals("bye")) {
                break;
            }
            
            printSeparatingLine();
            if (userInput.equals("list")){
                listAll();
            } else {
                addNew(userInput);
            }
            printSeparatingLine();
        }

        printSeparatingLine();
        outputText("Bye. Hope to see you again soon!");
        printSeparatingLine();
    }
}
