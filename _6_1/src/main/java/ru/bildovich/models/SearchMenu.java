package ru.bildovich.models;

import ru.bildovich.start.Tracker;
import ru.bildovich.start.UserAction;
import ru.bildovich.utils.DateValidator;

/**
 * Created by mac on 23.03.17.
 * Class
 */
public class SearchMenu extends MenuTracker{

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[7];

    public SearchMenu(Input input, Tracker tracker) {
        super(input, tracker);
        this.input = input;
        this.tracker = tracker;
    }

    @Override
    public void show() {

        for (UserAction action :
                this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }

    }

    @Override
    public void fillAction() {
        this.actions[0] = this.new ToTheName();
        this.actions[1] = this.new ToTheID();
    }

    @Override
    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public class ToTheName implements UserAction{

        @Override
        public int key() {
            return 0;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String name = input.ask("Pleas, enter the task's name: ");
            Item items[] = tracker.findByName(name);
            for (Item item:
                 items) {
                System.out.println(item);
            }
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "to the name.");
        }
    }

    public class ToTheID implements UserAction{

        @Override
        public int key() {
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String id = input.ask("Pleas, enter the task's ID: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item);

            } else {
                System.out.println(String.format("The item with id s% is not found! ", id));
            }

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "to the ID.");
        }
    }

    public class ToTheDate implements UserAction{

        @Override
        public int key() {
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String dateSelect = input.ask("Enter date in a format \"dd.MM.yyyy\": ");
            DateValidator dateValidator = new DateValidator();

            if (dateValidator.validate(dateSelect)) {
                Item[] findItems = tracker.findByDate(dateSelect);
                if (findItems != null && findItems.length > 0) {
                    for (Item item :
                            findItems) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Items with date" + "\"dateSelect + \" not found!");
                }

            } else {
                System.out.println("You entered not correct date!");
            }

        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "by creation date.");
        }
    }


}
