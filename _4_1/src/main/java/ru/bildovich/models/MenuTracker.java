package ru.bildovich.models;

import com.sun.javafx.binding.StringFormatter;
import ru.bildovich.start.Tracker;
import ru.bildovich.start.UserAction;

/**
 * bildovich
 * 05.03.2017.
 */
public class MenuTracker {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];
//    Action[] actions;

//    Action select(int index){
//        return this.actions[index];
//    }

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillAction() {
        this.actions[0] = new AddItem(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action :
                this.actions) {
            System.out.println(action.info());
        }
    }

    private class AddItem implements UserAction {

        public AddItem(Input input, Tracker tracker) {

        }

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Pleas, enter the task's name: ");
            String desc = input.ask("Pleas, enter the task's description: ");
            Item item = new Item(name);
            item.setDescription(desc);
            tracker.add(item);
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add the new item.");
        }
    }
}
