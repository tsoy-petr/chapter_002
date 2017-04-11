package ru.bildovich;

/**
 * Created by mac on 26.03.17.
 * Class
 */
public class Bishop extends Figure {

    public Bishop(Cell position) {
        super(position);
    }

    @Override
    Cell[] way(Cell dist) throws ImpossibleMoveException {

        Cell[] value = null;

        int x1 = this.position.getX();
        int y1 = this.position.getY();

        int x2 = dist.getX();
        int y2 = dist.getY();

        if ((x1 > 7 || y1 > 7)
                || (Math.abs(x1 - x2) != Math.abs(y1 - y2))) {
            throw new ImpossibleMoveException("Слон не может сделать такой ход!");
        } else {

            value = new Cell[Math.abs(x1-x2)];

//            вверх и влево
            if (x1 > x2 && y1 > y2) {

                int j = y1;

                for (int i1 = x1; i1 > x2;) {
                    j--;
                    value[x1 - i1] = new Cell(--i1, j);
                }
            }

//            вправо вверх
            if (x1 < x2 && y1 > y2) {

                int j = y1;

                for (int i1 = x1; i1 < x2;) {
                    j--;
                    value[i1-x1] = new Cell(++i1, j);
                }
            }

//            вниз и влево
            if (x1 > x2 && y1 < y2) {

                int j = y1;

                for (int i1 = x1; i1 > x2;) {
                    j++;
                    value[x1 - i1] = new Cell(--i1,j);
                }
            }

//            вправо и вниз
            if (x1 < x2 && y1 < y2) {
                int j = y1;
                for (int i1 = x1; i1 < x2;) {
                    j++;
                    value[i1 - x1] = new Cell( ++i1,j);
                }
            }

        }



        return value;
    }

    @Override
    Bishop clone(Cell position) {
        return new Bishop(position);
    }

}
