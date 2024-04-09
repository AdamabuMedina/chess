package main.java.com.adam.piece;

import main.java.com.adam.Color;
import main.java.com.adam.Coordinates;

abstract public class Piece {
    public final Color color;
    public Coordinates coordinates;

    public Piece(Color color, Coordinates coordinates) {
        this.color = color;
        this.coordinates = coordinates;
    }
}
