abstract class Task {
    private boolean done;
    private String description;

    public Task(String description) {
        this.done = false;
        this.description = description;
    }

    public static Task of(String userInput) {
        return new ToDo(userInput);
    }

    public void markDone() {
        this.done = true;
    }

    public void unmarkDone() {
        this.done = false;
    }

    @Override
    public String toString() {
        if (this.done) {
            return "[X] " + this.description;
        } else {
            return "[ ] " + this.description;
        }
    }
}