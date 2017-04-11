package ru.bildovich;

/**
 * Created by mac on 26.03.17.
 * Class
 */
public class ImpossibleMoveException extends RuntimeException{
    public ImpossibleMoveException(String message) {
        super(message);
    }
}
