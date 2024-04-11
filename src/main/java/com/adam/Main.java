package main.java.com.adam;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.setupDefaultPiecesPositions();
//
//        BoardConsoleRenderer renderer = new BoardConsoleRenderer();
//        renderer.render(board);
//
//        Piece piece = board.getPiece(new Coordinates(File.B, 1));
//        Set<Coordinates> availableMoveSquare = piece.getAvailableMoveSquare(board);
//
//        int a = 123;

        Game game = new Game(board);
        game.gameLoop();

    }
}
