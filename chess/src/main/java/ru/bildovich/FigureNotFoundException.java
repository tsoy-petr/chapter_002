package ru.bildovich;

/**
 * Created by mac on 26.03.17.
 * Class
 */
public class FigureNotFoundException extends RuntimeException {
    public FigureNotFoundException(String message) {
        super(message);
    }
}
