package ru.bildovich.start;

import ru.bildovich.models.Input;
import ru.bildovich.models.Item;
import ru.bildovich.models.MenuTracker;
import ru.bildovich.utils.DateValidator;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mac on 04.03.17.
 * Class
 */
public class StartUI {

    private Input input;

    public StartUI(Input input) {
        this.input = input;
    }

    /**
     * Main method.
     *
     * @param args progamme.
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput()).init();
    }

    public void init() {

        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillAction();

        do {

            menu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            menu.select(key);
        } while (! "y".equals(input.ask("Exit? (y/n): ")));

        }

    }

