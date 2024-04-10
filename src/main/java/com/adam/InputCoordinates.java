package main.java.com.adam;

import java.util.Scanner;

public class InputCoordinates {
    Scanner scanner = new Scanner(System.in);

    public Coordinates input() {
        while (true) {
            System.out.println("Пожалуйста введите координаты (например a1): ");
            String line = scanner.nextLine();

            if (line.length() != 2) {
                System.out.println("Неверный формат ввода!");
                continue;
            }

            char fileChar = line.charAt(0);
            char rankChar = line.charAt(1);

            if (!Character.isLetter(fileChar)) {
                System.out.println("Неверный формат ввода! Введите букву");
            }

            if (!Character.isDigit(rankChar)) {
                System.out.println("Неверный формат ввода! Введите цифру");
            }

            if ((int) rankChar < 1 || (int) rankChar > 8) {
                System.out.println("Неверный формат ввода! Введите число от 1 до 8");
            }

        }
    }
}
