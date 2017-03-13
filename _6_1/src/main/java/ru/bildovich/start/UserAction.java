package ru.bildovich.start;

import ru.bildovich.models.Input;

/**
 * Created by mac on 13.03.17.
 * Class
 */
public interface UserAction {

    int key();

    void execute(Input input, Tracker tracker);

    String info();

}
