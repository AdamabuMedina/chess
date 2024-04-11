package main.java.com.adam;

import main.java.com.adam.piece.Piece;

import java.util.Set;

public class Game {

    private final Board board;
    private final BoardConsoleRenderer renderer = new BoardConsoleRenderer();


    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;

        while (true) {
            renderer.render(board);

            if (isWhiteToMove) {
                System.out.println("Ходят белые! ");
            } else {
                System.out.println("Ходят черные!");
            }

            Coordinates sourceCoordinates = InputCoordinates.inputPieceCoordinatesForColor(
                    isWhiteToMove ? Color.WHITE : Color.BLACK, board
            );

            Piece piece = board.getPiece(sourceCoordinates);
            Set<Coordinates> availableMoveSquare = piece.getAvailableMoveSquare(board);

            Coordinates targetCoordinates = InputCoordinates.inputAvailableSquare(availableMoveSquare);

            board.movePiece(sourceCoordinates, targetCoordinates);

            isWhiteToMove = !isWhiteToMove;
        }
    }
}
