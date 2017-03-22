package ru.bildovich.models;

import com.sun.javafx.binding.StringFormatter;
import ru.bildovich.start.Tracker;
import ru.bildovich.start.UserAction;


class EditeItem implements UserAction {

    @Override
    public int key() {
        return 2;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Pleas, enter the task's ID: ");
        String name = input.ask("Pleas, enter the task's name: ");
        String desc = input.ask("Pleas, enter the task's description: ");
        Item item = new Item(id, name, desc, System.currentTimeMillis());
        tracker.edite(item);
    }

    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Edite item.");
    }
}


/**
 * bildovich
 * 05.03.2017.
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillAction() {
        this.actions[0] = this.new AddItem();
        this.actions[1] = new MenuTracker.ShowItems();
        this.actions[2] = new EditeItem();
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }
    public void show() {
        for (UserAction action :
                this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private class AddItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Pleas, enter the task's name: ");
            String desc = input.ask("Pleas, enter the task's description: ");
            Item item = new Item(Integer.toString(tracker.getSize()), name, desc, System.currentTimeMillis());
            item.setDescription(desc);
            tracker.add(item);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }

    private static class ShowItems implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println(tracker);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show all items.");
        }
    }
}
