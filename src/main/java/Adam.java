import java.util.ArrayList;
import java.util.Scanner;

public class Adam {
    private static TaskManager manager;
    private static final String INDENTATION = "    ";

    private static void printSeparatingLine() {
        System.out.println(INDENTATION +
                "____________________________________________________________");
    }

    private static void outputText(String text) {
        System.out.println(INDENTATION + " " + text);
    }

    private static void listAll() {
        ArrayList<String> outputs = manager.listAll();
        for (String output : outputs) {
            outputText(output);
        }
    }

    private static void addNew(String text) {
        try {
            Task toAdd = Task.of(text);
            manager.addTask(toAdd);

            outputText("Got it. I've added this task:");
            outputText(" " + toAdd);
        } catch (AdamException e) {
            outputText("Oh no! " + e);
        }
    }

    private static void markDone(int index) {
        try {
            Task task = manager.get(index - 1);
            task.markDone();
            outputText("Nice! I've marked this task as done:");
            outputText("  " + task);
        } catch (IndexOutOfBoundsException e) {
            outputText("Task index out of bounds!");
        }
    }

    private static void unmarkDone(int index) {
        try {
            Task task = manager.get(index-1);
            task.unmarkDone();
            outputText("OK, I've marked this task as not done yet:");
            outputText("  " + task);
        } catch (IndexOutOfBoundsException e) {
            outputText("Task index out of bounds!");
        }
    }

    private static void deleteTask(int index) {
        try {
            Task task = manager.deleteTask(index - 1);
            outputText("OK, I've deleted this task:");
            outputText("  " + task);
        } catch (IndexOutOfBoundsException e) {
            outputText("Task index out of bounds!");
        }
    }

    public static void main(String[] args) {
        String CHATBOT_NAME = "Adam";
        printSeparatingLine();
        outputText("Hello! I'm " + CHATBOT_NAME);
        outputText("What can I do for you?");
        printSeparatingLine();

        Scanner sc = new Scanner(System.in);
        manager = new TaskManager();

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
            } else if(inputParts[0].equals("delete") && inputParts.length == 2) {
                int index = Integer.parseInt(inputParts[1]);
                deleteTask(index);
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
