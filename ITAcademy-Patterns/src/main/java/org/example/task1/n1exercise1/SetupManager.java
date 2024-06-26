package org.example.task1.n1exercise1;

import java.util.List;
import java.util.Scanner;

public class SetupManager {

    Scanner scanner = new Scanner(System.in);
    Undo undoManager = Undo.getInstance();

    public void startMenu() {
        int option = 0;
        String message = "";
        do {
            message = "";
            option = Input.readInt(
                    "0. Exit\n" +
                            "1. Add Command\n" +
                            "2. Remove Last Command\n" +
                            "3. List Commands\n" +
                            "Choose an option: ");

            switch (option) {
                case 0:
                    message = "Exiting...";
                    scanner.close();
                    break;
                case 1:
                    String command = Input.readString("Enter command: ");
                    undoManager.addCommand(command);
                    message = "Command added";
                    break;
                case 2:
                    undoManager.removeCommand();
                    message = "Last command removed.";
                    break;
                case 3:
                    List<String> commands = undoManager.listCommands();
                    if (commands.isEmpty()) {
                        System.out.println("The commands history is empty.");
                    } else {
                        System.out.println("Command History: ");
                        for (String cmd : commands) {
                            System.out.println(cmd);
                        }
                    }
                    break;
                default:
                    message = "Invalid option. Please try again.";
            }
            System.out.println(message);
        } while (option != 0);
    }
}
