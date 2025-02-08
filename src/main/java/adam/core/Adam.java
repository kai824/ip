package adam.core;

import adam.exceptions.AdamException;
import adam.parser.Command;
import adam.parser.Parser;

/**
 * Represents the chatbot Adam.
 */
public class Adam {
    /** Name used in greeting */
    private static final String CHATBOT_NAME = "Adam";

    /** An instance of TaskList handling the information of current tasks */
    private TaskList manager;

    /**
     * Constructor for adam.core.Adam.
     *
     * Initializes the chatbot with a new Ui and a new TaskList.
     */
    public Adam() {
        this.manager = new TaskList(new Storage());
    }

    /**
     * Gets the response from the chatbot.
     *
     * @param input User input.
     * @return Response from the chatbot.
     */
    public String getResponse(String input) {
        try {
            Command c = Parser.parseInput(input);
            return c.execute(manager);
        } catch (AdamException e) {
            return "Oh no! " + e;
        }
    }
}
