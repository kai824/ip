package adam.exceptions;

public class EmptyDescription extends AdamException {
    public EmptyDescription() {
        super("Description is empty!");
    }
}
