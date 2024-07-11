package org.example.n2exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

    public static String readString(String message) {
        Scanner scannerString = new Scanner(System.in);
        try {
            System.out.println(message);
            return scannerString.nextLine();
        } catch (Exception e) {
            System.out.println("Format Error. Introduce a String.");
            return readString(message);
        }
    }

    public static int readInt(String message) {
        Scanner scannerInt = new Scanner(System.in);
        try {
            System.out.print(message);
            return scannerInt.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Input Invalid! Format Error: Expected an Int format - (e.g. 1).");
            return readInt(message);
        }
    }

    public static double readDouble(String message) {
        Scanner scannerDouble = new Scanner(System.in);
        try {
            System.out.print(message);
            return scannerDouble.nextDouble();
        } catch (InputMismatchException e) {
            System.out.println("Input Invalid! Format Error: Expected an Double format - (e.g. 1.0).");
            return readDouble(message);
        }
    }

    public static String readEmailString(String message) {
        Scanner scannerString = new Scanner(System.in);
        try {
            System.out.println(message);
            String userInput = scannerString.nextLine();
            if (isValidEmail(userInput)) {
                return userInput;
            } else {
                System.out.println("Format Error. Try to come up with an email format e.g. name@gmail.com");
                return readEmailString(message);
            }
        } catch (Exception e) {
            System.out.println("Format Error. Introduce a String.");
            return readString(message);
        }
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        return email.matches(regex);
    }
}