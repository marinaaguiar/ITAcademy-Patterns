package org.example.n2exercise1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    public static String readString(String message) {
        Scanner scannerString = new Scanner(System.in);
        String result = null;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(message);
                result = scannerString.nextLine();
                valid = true;
            } catch (Exception e) {
                System.out.println("Format Error. Introduce a String.");
            }
        }
        return result;
    }

    public static int readInt(String message) {
        Scanner scannerInt = new Scanner(System.in);
        int result = 0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(message);
                result = scannerInt.nextInt();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Input Invalid! Format Error: Expected an Int format - (e.g. 1).");
                scannerInt.next();
            }
        }
        return result;
    }

    public static double readDouble(String message) {
        Scanner scannerDouble = new Scanner(System.in);
        double result = 0.0;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.print(message);
                result = scannerDouble.nextDouble();
                valid = true; // input is valid, exit the loop
            } catch (InputMismatchException e) {
                System.out.println("Input Invalid! Format Error: Expected a Double format - (e.g. 1.0).");
                scannerDouble.next(); // clear the invalid input
            }
        }
        return result;
    }

    public static String readEmailString(String message) {
        Scanner scannerString = new Scanner(System.in);
        String result = null;
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println(message);
                result = scannerString.nextLine();
                if (isValidEmail(result)) {
                    valid = true; // input is valid, exit the loop
                } else {
                    System.out.println("Format Error. Try to come up with an email format e.g. name@gmail.com");
                }
            } catch (Exception e) {
                System.out.println("Format Error. Introduce a String.");
            }
        }
        return result;
    }

    public static boolean isValidEmail(String email) {
        String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
        return email.matches(regex);
    }
}
