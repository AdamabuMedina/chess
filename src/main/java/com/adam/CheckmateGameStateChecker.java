package main.java.com.adam;

import main.java.com.adam.board.Board;
import main.java.com.adam.board.BoardFactory;
import main.java.com.adam.board.Move;
import main.java.com.adam.piece.King;
import main.java.com.adam.piece.Piece;

import java.util.List;
import java.util.Set;

public class CheckmateGameStateChecker extends GameStateChecker {
    @Override
    public GameState check(Board board, Color color) {
        List<Piece> pieces = board.getPieceByColor(color);
        Piece king = pieces.stream().filter(piece -> piece instanceof King).findFirst().get();

        if (!board.isSquareAttackedByColor(king.coordinates, color.opposite())) {
            return GameState.ONGOING;
        }


        for (Piece piece : pieces) {
            Set<Coordinates> availableMoveSquare = piece.getAvailableMoveSquare(board);

            for (Coordinates coordinates : availableMoveSquare) {
                Board clone = new BoardFactory().copy(board);
                clone.makeMove(new Move(piece.coordinates, coordinates));

                Piece cloneBoardKing = clone.getPieceByColor(color).stream().filter(p -> p instanceof King).findFirst().get();

                if (!clone.isSquareAttackedByColor(cloneBoardKing.coordinates, color.opposite())) {
                    return GameState.ONGOING;
                }
            }
        }

        if (color == Color.WHITE) {
            return GameState.CHECKMATE_TO_WHITE_KING;
        } else {
            return GameState.CHECKMATE_TO_BLACK_KING;
        }
    }
}
