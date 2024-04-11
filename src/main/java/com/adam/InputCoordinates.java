package main.java.com.adam;

import java.util.Scanner;

public class InputCoordinates {
    private static final Scanner scanner = new Scanner(System.in);

    public static Coordinates input() {
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
                continue;
            }

            if (!Character.isDigit(rankChar)) {
                System.out.println("Неверный формат ввода! Введите цифру");
                continue;
            }

            int rank = Character.getNumericValue(rankChar);
            if (rank < 1 || rank > 8) {
                System.out.println("Неверный формат ввода! Введите число от 1 до 8");
                continue;
            }

            File file = File.fromChar(fileChar);
            if (file == null) {
                System.out.println("Неверный формат ввода!");
                continue;
            }
            ;

            return new Coordinates(file, (int) rankChar);

        }
    }

    public static void main(String[] args) {
        Coordinates coordinates = input();

        System.out.println("coordinates = " + coordinates);
    }
}
