package main.java.com.adam;

import main.java.com.adam.piece.Piece;

import java.util.Scanner;
import java.util.Set;

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

            return new Coordinates(file, rank);

        }
    }

    public static Coordinates inputPieceCoordinatesForColor(Color color, Board board) {
        while (true) {
            System.out.println("Введите координаты фигуры для перемещения: ");
            Coordinates coordinates = input();

            if (board.isSquareEmpty(coordinates)) {
                System.out.println("Пустая клетка! ");
                continue;
            }

            Piece piece = board.getPiece(coordinates);
            if (piece.color != color) {
                System.out.println("Неверный цвет! ");
                continue;
            }

            Set<Coordinates> availableMoveSquares = piece.getAvailableMoveSquare(board);
            if (availableMoveSquares.isEmpty()) {
                System.out.println("Фигура заблокирована");
                continue;
            }

            return coordinates;
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecesPositions();

        Coordinates coordinates = inputPieceCoordinatesForColor(Color.WHITE, board);
        System.out.println("coordinates = " + coordinates);
    }
}
