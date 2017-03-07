package ru.bildovich.start;

import ru.bildovich.models.Input;
import ru.bildovich.models.Item;

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

    public void init(){

        Tracker tracker = new Tracker();

        int answer;
        String answerString;
        while (true) {

            System.out.println("Система учета заявок");
            System.out.println("");
            System.out.println("1 - Добавить новую заявку");
            System.out.println("2 - Редактировать заявку");
            System.out.println("3 - Удалить заявку");
            System.out.println("4 - Вывести все заявки");
            System.out.println("5 - Вевести спислк заявок с отбором");
            System.out.println("6 - Добавить к заявке комментарий");
            System.out.println("7 - Выход");
            System.out.println();

            answerString = input.ask("Введите номер пункта: ");
            if (answerString.isEmpty()) continue;

            answer = Integer.parseInt(answerString);

            if (answer == 1) {
                String nameItem = input.ask("Введите имя заявки: ");
                if (!answerString.isEmpty()) {
                    tracker.add(new Item(nameItem));
                }
            } else if (answer == 2) {
                String nameItem = input.ask("Введите имя редактируемой заявки: ");
                if (!answerString.isEmpty()) {
                    Item[] foundItem = tracker.findByName(nameItem);
                }
            }else if (answer == 7) {
                break;
            } else if (answer == 4) {
                System.out.println(" ------------------------------------- ");
                System.out.println();
                System.out.println(tracker);
                System.out.println();
                System.out.println(" ------------------------------------- ");
            } else break;


        }
//        ConsoleInput consoleInput = new ConsoleInput();
//        String name = consoleInput.ask("Please, enter the task's name: ");

//        Tracker tracker = new Tracker();
//        tracker.add(new Item(name));
//        for (Item item:
//             tracker.findAll()) {
//            System.out.println(item.getName());
//        }
//        System.out.println(tracker.getItems()[tracker.getSize() - 1].getId());
//        System.out.println(System.currentTimeMillis());

    }
}
