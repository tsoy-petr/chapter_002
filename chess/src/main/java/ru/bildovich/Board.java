package ru.bildovich;

/**
 * Created by mac on 26.03.17.
 * Class
 */
public class Board {

    private Figure[] figures;

    public Board(Figure[] figures) {
        this.figures = figures;
    }

    public boolean move(Cell source, Cell dist) throws ImpossibleMoveException, OccupiedWayException, FigureNotFoundException {

        boolean found = false;
        Figure currentFigure = null;
        int currentIndex = 0;

        for (int i = 0; i < figures.length; i++) {
            Figure figure = figures[i];
            if (figure.position.getY() == source.getY() && figure.position.getX() == source.getX() && figure instanceof Bishop) {
                found = true;
                currentFigure = figure;
                currentIndex = i;
                break;
            }
        }

        if (!found) {
            throw new FigureNotFoundException("Фигура не найдена");
        }

        Cell[] way = currentFigure.way(dist);
        if (way.length == 0) {
            throw new ImpossibleMoveException("Слон остался на месте!");
        }


        for (Figure figure :
                figures) {
            for (int i = 0; i < way.length; i++) {

                if (figure.position.getX() == way[i].getX() && figure.position.getY() == way[i].getY()) {
                  throw new OccupiedWayException("Путь занять фигурами");
                }

            }
        }

        figures[currentIndex] = currentFigure.clone(dist);

        return true;
    }
}
