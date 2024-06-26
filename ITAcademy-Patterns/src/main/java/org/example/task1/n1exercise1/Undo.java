package org.example.task1.n1exercise1;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo singleInstance = null;
    private List<String> commandHistory = new ArrayList<>();

    public static Undo getInstance() {
        if (singleInstance == null) {
            singleInstance = new Undo();
        }
        return singleInstance;
    }

    public void addCommand(String command) {
        commandHistory.add(command);
    }

    public void removeCommand() {
        if (!commandHistory.isEmpty()) {
            commandHistory.remove(commandHistory.size() - 1);
        }
    }

    public List<String> listCommands() {
        return new ArrayList<>(commandHistory);
    }
}