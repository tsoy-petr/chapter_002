package ru.bildovich;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Created by mac on 27.03.17.
 * Class
 */
public class TestChess {

    @Test
    public void WhenBishopWayRight() {
        Cell source = new Cell(7, 7);
        Cell dist = new Cell(4, 4);
        Bishop bishop = new Bishop(source);
        Cell[] res= bishop.way(dist);
        assertThat(3, is(res.length));
    }

    @Test
    public void WhenBishopWayWrong() {
        Cell source = new Cell(7, 7);
        Cell dist = new Cell(5, 3);
        Bishop bishop = new Bishop(source);
        Cell[] res= bishop.way(dist);
        assertThat(0, is(res.length));
    }

    @Test
    public void WhenBishopWayWrongExeption() {
        Cell source = new Cell(7, 8);
        Cell dist = new Cell(5, 3);
        Bishop bishop = new Bishop(source);
        Cell[] res= bishop.way(dist);
        assertThat(1, is(res.length));
    }
}
