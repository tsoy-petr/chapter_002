package ru.bildovich;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mac on 10.03.17.
 * Class
 */
public class TestSquare {

    @Test
    public void testShapeSquare() {
        Shape square = new Square();
        String result = square.pic();
        String checked = "***\n***\n***";
        assertThat(result, is(checked));
    }
}
