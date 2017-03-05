package ru.bildovich.start;

import ru.bildovich.models.Item;

/**
 * Created by mac on 04.03.17.
 */
public class StartUI {

    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        tracker.add(new Item());
        System.out.println(tracker.getItems()[tracker.getSize()-1].getId());
        System.out.println(System.currentTimeMillis());
    }
}
