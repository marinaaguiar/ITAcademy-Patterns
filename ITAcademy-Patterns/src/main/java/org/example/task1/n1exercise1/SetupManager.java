package org.example.task1.n1exercise1;

import java.util.List;
import java.util.Scanner;

public class SetupManager {

    private Undo undoManager = Undo.getInstance();

    public void startMenu() {
        int option = 0;
        String message = "";
        do {
            option = Input.readInt(
                    "0. Exit\n" +
                            "1. Add Command\n" +
                            "2. Remove Last Command\n" +
                            "3. List Commands\n" +
                            "Choose an option: ");

            switch (option) {
                case 0:
                    message = "Exiting...";
                    Input.closeScanner();
                    break;
                case 1:
                    String command = Input.readString("Enter command: ");
                    undoManager.addCommand(command);
                    message = "New command: " + command + " added!\n";
                    break;
                case 2:
                    undoManager.removeCommand();
                    message = "Last command removed!\n";
                    break;
                case 3:
                    List<String> commands = undoManager.listCommands();
                    if (commands.isEmpty()) {
                        message = "The commands history is empty.\n";
                    } else {
                        message = "";
                        System.out.println("Command History: ");
                        for (String cmd : commands) {
                            System.out.println(cmd);
                        }
                    }
                    break;
                default:
                    message = "Invalid option. Please try again.\n";
            }
            System.out.println(message);
        } while (option != 0);
    }
}

