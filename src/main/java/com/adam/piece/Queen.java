package main.java.com.adam.piece;

import main.java.com.adam.Color;
import main.java.com.adam.Coordinates;

import java.util.Set;

public class Queen extends Piece {
    public Queen(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        return Set.of();
    }
}
