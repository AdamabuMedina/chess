package main.java.com.adam.piece;

import main.java.com.adam.Color;
import main.java.com.adam.Coordinates;

import java.util.HashSet;
import java.util.Set;

public class Bishop extends Piece {
    public Bishop(Color color, Coordinates coordinates) {
        super(color, coordinates);
    }

    @Override
    protected Set<CoordinatesShift> getPieceMoves() {
        Set<CoordinatesShift> result = new HashSet<>();

        // bottom-left to bottom-right
        for (int i = -7; i < 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, i));
        }

        // top-left to bottom-right
        for (int i = -7; i < 7; i++) {
            if (i == 0) continue;

            result.add(new CoordinatesShift(i, -i));
        }

        return result;
    }
}
