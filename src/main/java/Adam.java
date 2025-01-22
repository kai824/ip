import java.util.ArrayList;
import java.util.Scanner;

public class Adam {
    private static ArrayList<Task> tasks;
    private static final String INDENTATION = "    ";

    private static void printSeparatingLine() {
        System.out.println(INDENTATION +
            "____________________________________________________________");
    }

    private static void outputText(String text) {
        System.out.println(INDENTATION + " " + text);
    }

    private static void listAll() {
        for (int i = 0; i < Adam.tasks.size(); i++) {
            outputText(String.format("%d. %s", i + 1, Adam.tasks.get(i)));
        }
    }

    private static void addNew(String text) {
        Task toAdd = Task.of(text);
        Adam.tasks.add(toAdd);

        outputText("Got it. I've added this task:");
        outputText(" " + toAdd);
    }

    private static boolean checkIndexOverflow(int index) {
        if (index > tasks.size()) {
            outputText("Task index out of bounds!");
            return true;
        }
        return false;
    }

    private static void markDone(int index) {
        if(checkIndexOverflow(index)) return;
        Task task = tasks.get(index-1);
        task.markDone();
        outputText("Nice! I've marked this task as done:");
        outputText("  " + task);
    }

    private static void unmarkDone(int index) {
        if(checkIndexOverflow(index)) return;
        Task task = tasks.get(index-1);
        task.unmarkDone();
        outputText("OK, I've marked this task as not done yet:");
        outputText("  " + task);
    }

    public static void main(String[] args) {
        String CHATBOT_NAME = "Adam";
        printSeparatingLine();
        outputText("Hello! I'm " + CHATBOT_NAME);
        outputText("What can I do for you?");
        printSeparatingLine();

        Scanner sc = new Scanner(System.in);
        tasks = new ArrayList<Task>();

        while(true) {
            String userInput = sc.nextLine();
            if (userInput.equals("bye")) {
                break;
            }
            
            printSeparatingLine();
            String[] inputParts = userInput.split(" ");
            if (userInput.equals("list")){
                listAll();
            } else if(inputParts[0].equals("mark") && inputParts.length == 2) {
                int index = Integer.parseInt(inputParts[1]);
                markDone(index);
            } else if(inputParts[0].equals("unmark") && inputParts.length == 2) {
                int index = Integer.parseInt(inputParts[1]);
                unmarkDone(index);
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
