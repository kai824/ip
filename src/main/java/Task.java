import java.util.ArrayList;
import java.util.List;

abstract class Task {
    private boolean isDone;
    private String description;

    public Task(String description) throws AdamException {
        if (description.equals("")) {
            throw new EmptyDescription();
        }
        this.isDone = false;
        this.description = description;
    }

    private static List<String> splitDescription(List<String> input, List<String> delimiters) 
        throws AdamException {
        String cur = "";
        int delimiterIndex = 0;
        List<String> results = new ArrayList<String>();

        for (int i = 1; i < input.size(); i++) {
            if (delimiterIndex < delimiters.size() &&
              delimiters.get(delimiterIndex).equals(input.get(i))) {
                results.add(cur);
                cur = "";

                delimiterIndex++;
            } else {
                if (cur.length() > 0) {
                    cur += " ";
                }
                cur += input.get(i);
            }
        }

        results.add(cur);

        if (delimiterIndex < delimiters.size()) {
            throw new MissingArgument(delimiters.get(delimiterIndex));
        }

        return results;
    }

    public static Task of(String userInput) throws AdamException {
        List<String> parts = List.of(userInput.split(" "));
        if (parts.get(0).equals("todo")) {
            List<String> split = splitDescription(parts, List.of());
            return new ToDo(split.get(0));
        } else if(parts.get(0).equals("deadline")) {
            List<String> split = splitDescription(parts, List.of("/by"));
            return new Deadline(split.get(0), split.get(1));
        } else if(parts.get(0).equals("event")) {
            List<String> split = splitDescription(parts, List.of("/from", "/to"));
            return new Event(split.get(0), split.get(1), split.get(2));
        }
        throw new InvalidCommand();
    }

    public void markDone() {
        this.isDone = true;
    }

    public void unmarkDone() {
        this.isDone = false;
    }

    @Override
    public String toString() {
        if (this.isDone) {
            return "[X] " + this.description;
        } else {
            return "[ ] " + this.description;
        }
    }
}