package ru.bildovich;

/**
 * Created by mac on 10.03.17.
 * Class
 */
public class Main {
    public static void main(String[] args) {
        Paint paint = new Paint();
        paint.draw(new Triangle());
        paint.draw(new Square());
    }
}
