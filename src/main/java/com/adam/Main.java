package main.java.com.adam;

import main.java.com.adam.board.Board;
import main.java.com.adam.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        // Board board = new Board();
        // board.setupDefaultPiecesPositions();

        Board board = (new BoardFactory()).fromFEN(
                "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
        );

        // BoardConsoleRenderer renderer = new BoardConsoleRenderer();
        // renderer.render(board);

        // Piece piece = board.getPiece(new Coordinates(File.B, 1));
        // Set<Coordinates> availableMoveSquare = piece.getAvailableMoveSquare(board);
        //
        // int a = 123;

        Game game = new Game(board);
        game.gameLoop();

    }
}
