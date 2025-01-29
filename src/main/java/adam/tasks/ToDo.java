package adam.tasks;

import adam.exceptions.AdamException;

import java.time.LocalDate;

public class ToDo extends Task {
    public ToDo(String description) throws AdamException {
        super(description);
    }
    
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }

    @Override
    public String log() {
        return "T | " + super.log();
    }

    @Override
    public boolean isOn(LocalDate date) {
        return false;
    }
}