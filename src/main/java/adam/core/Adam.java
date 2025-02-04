package adam.core;

import adam.exceptions.AdamException;
import adam.input_handler.Command;
import adam.input_handler.Parser;

/**
 * Represents the chatbot Adam.
 */
public class Adam {
    /** Name used in greeting */
    private static final String CHATBOT_NAME = "Adam";

    /** An instance of TaskList handling the information of current tasks */
    private TaskList manager;

    /** An instance of Ui handling user interaction */
    private Ui ui;

    Adam() {
        this.ui = new Ui();
        this.manager = new TaskList(new Storage());
    }

    /**
     * Runs the chatbot.
     */
    public void run() {
        ui.greet(Adam.CHATBOT_NAME);

        boolean hasExited = false;
        while (!hasExited) {
            String input = ui.getUserInput();
            ui.printSeparatingLine();
            try {
                Command c = Parser.parseInput(input);
                c.execute(manager, ui);

                hasExited = c.isExit();
            } catch (AdamException e) {
                ui.outputText("Oh no! " + e);
            }
            ui.printSeparatingLine();
        }
    }

    /**
     * Main entry-point for the java.adam.Duke application.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        new Adam().run();
    }
}
