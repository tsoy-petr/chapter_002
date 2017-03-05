package ru.bildovich.start;

import ru.bildovich.models.Input;
import ru.bildovich.models.Item;

/**
 * Created by mac on 04.03.17.
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
//        Tracker tracker = new Tracker();
//        tracker.add(new Item());
//        System.out.println(tracker.getItems()[tracker.getSize() - 1].getId());
//        System.out.println(System.currentTimeMillis());

        new StartUI(new ConsoleInput()).init();
    }

    public void init(){

        int answer = 0;
        String answerString = "0";
        while (true)
        {

            System.out.println("Система учета заявок");
            System.out.println("1 - Добавление новой заявки");
            System.out.println("2 - Редактирования заявки");
            System.out.println("3 - Удаления заявки");
            System.out.println("4 - Отображение списка всех заявок");
            System.out.println("5 - Отображения заявок с условием фильтра");
            System.out.println("6 - Добавить к заявке комментарий");
            System.out.println("7 - Выход");
            System.out.println();

            answerString = input.ask("Введите номер пункта: ");
            if (answerString.isEmpty()) continue;

            answer = Integer.parseInt(answerString);




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
