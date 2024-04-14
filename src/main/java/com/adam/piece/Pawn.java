package main.java.com.adam.piece;

import main.java.com.adam.Color;
import main.java.com.adam.Coordinates;

import java.util.HashSet;
import java.util.Set;

public class Pawn extends Piece {
    public Pawn(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        if (color == Color.WHITE) {
            result.add(new CoordinatesShift(0, 1));

            if (coordinates.rank == 2) {
                result.add(new CoordinatesShift(0, 2));
            }
        } else {
            result.add(new CoordinatesShift(0, -1));

            if (coordinates.rank == 7) {
                result.add(new CoordinatesShift(0, -2));
            }
        }

        return result;
    }
}
