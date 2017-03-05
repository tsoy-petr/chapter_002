package ru.bildovich.models;

/**
 * bildovich
 * 05.03.2017.
 */
public class MenuTracker {

    Action[] actions;

    Action select(int index){
        return this.actions[index];
    }

}
