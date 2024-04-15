package main.java.com.adam;

import main.java.com.adam.board.Board;
import main.java.com.adam.board.Move;

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

            Move move = InputCoordinates.inputMove(board, isWhiteToMove ? Color.WHITE : Color.BLACK, renderer);

            board.moveMove(move);

            isWhiteToMove = !isWhiteToMove;
        }
    }


}
