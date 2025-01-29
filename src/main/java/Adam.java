import java.time.LocalDate;
import java.util.ArrayList;

public class Adam {
    private static TaskList manager;
    private static Ui ui;

    private static void listAll() {
        ArrayList<String> outputs = manager.listAll();
        for (String output : outputs) {
            ui.outputText(output);
        }
    }

    private static void listAllOnDate(String date) {
        try {
            LocalDate parsedDate = Parser.parseInputDate(date);
            ArrayList<String> outputs = manager.listAllOnDate(parsedDate);
            for (String output : outputs) {
                ui.outputText(output);
            }
        } catch (AdamException e) {
            ui.outputText("Oh no! " + e);
        }
    }

    private static void addNew(String text) {
        try {
            Task toAdd = Task.of(text);
            manager.addTask(toAdd);

            ui.outputText("Got it. I've added this task:");
            ui.outputText(" " + toAdd);
        } catch (AdamException e) {
            ui.outputText("Oh no! " + e);
        }
    }

    private static void markDone(int index) {
        try {
            String taskText = manager.markDone(index - 1);
            ui.outputText("Nice! I've marked this task as done:");
            ui.outputText("  " + taskText);
        } catch (IndexOutOfBoundsException e) {
            ui.outputText("Task index out of bounds!");
        }
    }

    private static void unmarkDone(int index) {
        try {
            String taskText = manager.unmarkDone(index-1);
            ui.outputText("OK, I've marked this task as not done yet:");
            ui.outputText("  " + taskText);
        } catch (IndexOutOfBoundsException e) {
            ui.outputText("Task index out of bounds!");
        }
    }

    private static void deleteTask(int index) {
        try {
            Task task = manager.deleteTask(index - 1);
            ui.outputText("OK, I've deleted this task:");
            ui.outputText("  " + task);
        } catch (IndexOutOfBoundsException e) {
            ui.outputText("Task index out of bounds!");
        }
    }

    public static void main(String[] args) {
        String CHATBOT_NAME = "Adam";
        ui = new Ui();
        ui.printSeparatingLine();
        ui.outputText("Hello! I'm " + CHATBOT_NAME);
        ui.outputText("What can I do for you?");
        ui.printSeparatingLine();

        manager = new TaskList(new Storage());

        while(true) {
            String userInput = ui.getUserInput();
            if (userInput.equals("bye")) {
                break;
            }
            
            ui.printSeparatingLine();
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
            } else if(inputParts[0].equals("listOn") && inputParts.length == 2) {
                listAllOnDate(inputParts[1]);
            } else {
                addNew(userInput);
            }
            ui.printSeparatingLine();
        }

        ui.printSeparatingLine();
        ui.outputText("Bye. Hope to see you again soon!");
        ui.printSeparatingLine();
    }
}
