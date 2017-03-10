package ru.bildovich;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by mac on 10.03.17.
 * Class
 */
public class TestTriangle {

    @Test
    public void testShapeTriangle() {
        Shape triangle = new Triangle();
        String result = triangle.pic();
        String checked = "  *\n" + " ***\n" + "*****\n";
        assertThat(result, is(checked));
    }
}
