package ru.bildovich.start;

import ru.bildovich.models.Input;

/**
 * Created by mac on 26.03.17.
 * Class
 */
public abstract class BaseAction implements UserAction{

    private String name;
    private int key;

    public BaseAction(String name) {
        this.name = name;
    }

    public abstract int key();

    public abstract void execute(Input input, Tracker tracker);

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), this.name);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }
}
