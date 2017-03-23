package ru.bildovich.models;

import com.sun.javafx.binding.StringFormatter;
import ru.bildovich.start.Tracker;
import ru.bildovich.start.UserAction;


final class EditeItem implements UserAction {

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
        this.actions[3] = this.new DeleteItem();
        this.actions[4] = this.new OutputWithSelection();
        this.actions[5] = this.new AddComment();
        this.actions[6] = this.new ShowComments();
    }

    public void select(int key) {
        actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action :
                this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }

    private final class AddItem implements UserAction {

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

    private final class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Pleas, enter the task's ID: ");
            Item item = tracker.findById(id);
            if (item != null) {
                tracker.delete(item);
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Delete item.");
        }
    }

    private final class OutputWithSelection implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {

            SearchMenu menuSearch = new SearchMenu(input, tracker);
            menuSearch.fillAction();

            do {
                menuSearch.show();
                int key = Integer.valueOf(input.ask("Select: "));
                menuSearch.select(key);
            } while (!"y".equals(input.ask("Exit? (y/n): ")));

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "To output the list of items with selection.");
        }
    }

    private final class AddComment implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Pleas, enter the task's ID: ");
            Item item = tracker.findById(id);
            if (item != null) {
                String comment = input.ask("Pleas, enter the new comment: ");
                item.getComments().add(comment);
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Add comments.");
        }
    }

    private final class ShowComments implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Pleas, enter the task's ID: ");
            Item item = tracker.findById(id);
            if (item != null) {
                for (String comment:
                     item.getComments()) {
                    System.out.println(comment);
                }
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Show comments.");
        }
    }

    private final static class ShowItems implements UserAction {

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
