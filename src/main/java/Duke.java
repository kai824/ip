public class Duke {
    private static void printSeparatingLine() {
        System.out.println("____________________________________________________________");
    }
    private static void outputText(String text) {
        System.out.println(" " + text);
    }
    public static void main(String[] args) {
        String CHATBOT_NAME = "Duke";
        Duke.printSeparatingLine();
        Duke.outputText("Hello! I'm " + CHATBOT_NAME);
        Duke.outputText("What can I do for you?");
        Duke.printSeparatingLine();
        Duke.outputText("Bye. Hope to see you again soon!");
        Duke.printSeparatingLine();
    }
}
