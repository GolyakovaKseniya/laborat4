package ru.golyakova.validate;

import java.util.Scanner;

public class Validator {
    static Scanner scanner = new Scanner(System.in);

    public static int inputInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите целое число.");
            }
        }
    }

    public static double inputDouble() {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ошибка! Введите число.");
            }
        }
    }
}