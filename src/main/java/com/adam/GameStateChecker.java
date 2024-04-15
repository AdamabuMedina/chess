package main.java.com.adam;

import main.java.com.adam.board.Board;

public abstract class GameStateChecker {
    public abstract GameState check(Board board, Color color);
}
