package main.java.com.adam;

import main.java.com.adam.board.Board;
import main.java.com.adam.board.BoardFactory;

public class Main {
    public static void main(String[] args) {
        // Board board = new Board();
        // board.setupDefaultPiecesPositions();

        Board board = (new BoardFactory()).fromFEN(
//                "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1"
                // "3k4/8/5n2/2N5/3B4/8/8/3K4 w - - 0 1"
                // "3k4/8/p7/8/R7/8/P7/3K4 w - - 0 1"
                // "3k4/8/p5p1/5B2/R7/3P4/P7/3K4 w - - 0 1"
                // "3p4/6b1/8/1P2Q3/2B5/6P1/2R1r3/3P4 w - - 0 1"
//                "1k6/6p1/5p2/4N3/2n1B1b1/3P2P1/2P5/8 w - - 0 1"
//                "k7/8/4n3/8/4K3/8/8/8 w - - 0 1"
//                "k4r2/8/8/r7/4KN2/2q1N3/8/8 w - - 0 1"
//                "k7/8/4p3/8/4K3/8/8/8 w - - 0 1"
                "3k4/8/8/b7/8/8/2PK4/6N1 w - - 0 1"
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
