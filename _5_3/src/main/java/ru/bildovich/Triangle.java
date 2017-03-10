package ru.bildovich;

/**
 * Created by mac on 10.03.17.
 * Class
 */
public class Triangle implements Shape {
    @Override
    public String pic() {
        String result = "  *\n" + " ***\n" + "*****\n";
        return result;
    }
}
