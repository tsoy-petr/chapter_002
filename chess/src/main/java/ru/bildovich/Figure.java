package ru.bildovich;

/**
 * Created by mac on 26.03.17.
 * Class
 */
public abstract class Figure {

    public final Cell position;

    public Figure(Cell position) {
        this.position = position;
    }

    abstract Cell[] way(Cell dist) throws ImpossibleMoveException;

    abstract Figure clone(Cell position);
}
