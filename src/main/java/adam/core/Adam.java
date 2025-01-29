package adam.core;

import adam.input_handler.Command;
import adam.input_handler.Parser;
import adam.exceptions.AdamException;
import adam.exceptions.EmptyDescription;

import java.time.LocalDate;
import java.util.ArrayList;

public class Adam {
    private static final String CHATBOT_NAME = "Adam";
    private TaskList manager;
    private Ui ui;

    Adam() {
        this.ui = new Ui();
        this.manager = new TaskList(new Storage());
    }

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

    public static void main(String[] args) {
        new Adam().run();
    }
}
