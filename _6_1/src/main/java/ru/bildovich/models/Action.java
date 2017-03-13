package ru.bildovich.models;

import ru.bildovich.start.Tracker;

/**
 * bildovich
 * 05.03.2017.
 */
public interface Action {

    void execute(Tracker tracker, Input input);
}
