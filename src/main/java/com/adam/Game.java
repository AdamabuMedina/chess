package main.java.com.adam;

public class Game {

    private final Board board;
    private BoardConsoleRenderer renderer = new BoardConsoleRenderer();


    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        boolean isWhiteToMove = true;

        while (true) {
            renderer.render(board);
            // input

            // make move

            // pass move
            isWhiteToMove = !isWhiteToMove;
        }
    }
}
