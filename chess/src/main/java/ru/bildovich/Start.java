package ru.bildovich;

/**
 * Created by mac on 11.04.17.
 * Class
 */
public class Start {
    public static void main(String[] args) {

        Figure[] figures = new Figure[] {
        new Bishop(new Cell(5,5)), new Bishop(new Cell(3, 5)),
        new Bishop(new Cell(5, 1)), new Bishop(new Cell(0,4))
        };

        if (new Board(figures).move(new Cell(5, 5), new Cell(2,2))) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }

        if (new Board(figures).move(new Cell(3, 5), new Cell(6,2))) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }

        if (new Board(figures).move(new Cell(5, 1), new Cell(2,4))) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }


        if (new Board(figures).move(new Cell(0, 4), new Cell(3,7))) {
            System.out.println("OK");
        } else {
            System.out.println("NO");
        }
    }
}
