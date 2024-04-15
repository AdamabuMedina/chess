package main.java.com.adam;

import main.java.com.adam.board.Board;
import main.java.com.adam.board.Move;

import java.util.Collections;
import java.util.List;

public class Game {

    private final Board board;
    private final BoardConsoleRenderer renderer = new BoardConsoleRenderer();
    private final List<GameStateChecker> checkers = Collections.emptyList();

    public Game(Board board) {
        this.board = board;
    }

    public void gameLoop() {
        Color colorToMove = Color.WHITE;

        GameState state = determineGameState(board, colorToMove);

        while (state == GameState.ONGOING) {
            renderer.render(board);

            if (colorToMove == Color.WHITE) {
                System.out.println("Ходят белые! ");
            } else {
                System.out.println("Ходят черные!");
            }

            Move move = InputCoordinates.inputMove(board, colorToMove, renderer);

            board.makeMove(move);

            colorToMove = colorToMove.opposite();

            state = determineGameState(board, colorToMove);
        }

        renderer.render(board);
        System.out.println("Игра закончилась = " + state);
    }

    private GameState determineGameState(Board board, Color color) {
        for (GameStateChecker checker : checkers) {
            GameState state = checker.check(board, color);

            if (state != GameState.ONGOING) {
                return state;
            }
        }
        return GameState.ONGOING;
    }
}
