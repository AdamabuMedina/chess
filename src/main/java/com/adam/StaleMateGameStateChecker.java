package main.java.com.adam;

import main.java.com.adam.board.Board;
import main.java.com.adam.piece.Piece;

import java.util.List;
import java.util.Set;

public class StaleMateGameStateChecker extends GameStateChecker {

    @Override
    public GameState check(Board board, Color color) {
        List<Piece> pieces = board.getPieceByColor(color);

        for (Piece piece : pieces) {
            Set<Coordinates> availableMoveSquare = piece.getAvailableMoveSquare(board);

            if (!availableMoveSquare.isEmpty()) {
                return GameState.ONGOING;
            }
        }

        return GameState.STALEMATE;
    }
}
