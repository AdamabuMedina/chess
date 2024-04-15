package main.java.com.adam;

import main.java.com.adam.board.Board;
import main.java.com.adam.board.BoardFactory;
import main.java.com.adam.board.Move;
import main.java.com.adam.piece.King;
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

    public static Coordinates inputAvailableSquare(Set<Coordinates> coordinates) {
        while (true) {
            System.out.println("Введите ход для выбранной фигуры");
            Coordinates input = input();

            if (!coordinates.contains(input)) {
                System.out.println("Недоступное для хода клетка!");
                continue;
            }

            return input;
        }
    }

    public static Move inputMove(Board board, Color color, BoardConsoleRenderer renderer) {
        while (true) {
            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                    color, board
            );

            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableMoveSquare = piece.getAvailableMoveSquare(board);

            renderer.render(board, piece);
            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquare);

            Move move = new Move(sourceCoordinates, targetCoordinates);
            if (validateIfKingInCheckAfterMove(board, color, move)) {
                System.out.println("Ваш король находится под атакой (под шахом)");
                continue;
            }

            return move;
        }

    }

    private static boolean validateIfKingInCheckAfterMove(Board board, Color color, Move move) {
        Board copy = (new BoardFactory()).copy(board);
        copy.makeMove(move);

        // допущение король есть у доски
        Piece king = copy.getPieceByColor(color).stream().filter(piece -> piece instanceof King).findFirst().get();
        return copy.isSquareAttackedByColor(king.coordinates, color.opposite());
    }

}
