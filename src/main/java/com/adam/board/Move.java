package main.java.com.adam.board;

import main.java.com.adam.Coordinates;

public class Move {
    public final Coordinates from, to;

    public Move(Coordinates from, Coordinates coordinates) {
        this.from = from;
        to = coordinates;
    }
}
