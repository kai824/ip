public class Adam {
    private static void printSeparatingLine() {
        System.out.println("____________________________________________________________");
    }

    private static void outputText(String text) {
        System.out.println(" " + text);
    }
    
    public static void main(String[] args) {
        String CHATBOT_NAME = "Adam";
        printSeparatingLine();
        outputText("Hello! I'm " + CHATBOT_NAME);
        outputText("What can I do for you?");
        printSeparatingLine();
        outputText("Bye. Hope to see you again soon!");
        printSeparatingLine();
    }
}
