package org.example.task1.n1exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String readString(String message) {
        String userInput = "";
        while (userInput.isEmpty()) {
            try {
                System.out.println(message);
                userInput = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Format Error. Introduce a String.");
            }
        }
        return userInput;
    }

    public static int readInt(String message) {
        int intInfo = 0;
        boolean isValid = false;
        while (!isValid) {
            try {
                System.out.print(message);
                intInfo = scanner.nextInt();
                isValid = true;
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input Invalid! Format Error: Expected an Int format - (e.g. 1).");
                scanner.nextLine();
            }
        }
        return intInfo;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
