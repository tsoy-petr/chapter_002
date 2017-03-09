package ru.bildovich.start;

import ru.bildovich.models.Input;
import ru.bildovich.models.Item;
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

        int answer;
        String answerString;
        while (true) {

            System.out.println("");
            System.out.println("Система учета заявок");
            System.out.println("");
            System.out.println("1 - Добавить новую заявку");
            System.out.println("2 - Редактировать заявку");
            System.out.println("3 - Удалить заявку");
            System.out.println("4 - Вывести все заявки");
            System.out.println("5 - Вевести список заявок с отбором");
            System.out.println("6 - Добавить к заявке комментарий");
            System.out.println("7 - Выход");
            System.out.println();

            answerString = input.ask("Введите номер пункта: ");
            if (answerString.isEmpty()) continue;

            answer = Integer.parseInt(answerString);

            if (answer == 1) {

                String nameItem = input.ask("Введите имя заявки: ");
                String descItem = input.ask("Введите описание: ");
                if (!answerString.isEmpty()) {
                    tracker.add(new Item(Integer.toString(tracker.getSize())
                            , nameItem, descItem, System.currentTimeMillis()));
                }

            } else if (answer == 2) {

                String idItem = input.ask("Введите ID редактируемой заявки: ");
                if (!answerString.isEmpty()) {
                    Item foundItem;
                    if ((foundItem = tracker.findById(idItem)) != null) {
                        String newName = input.ask("Введите новое имя заявки: ");
                        String newDesc = input.ask("Введите новое описание заявки: ");
                        if (newName != null && !newName.isEmpty()) {
                            foundItem.setName(newName);
                        }
                        if (newDesc != null && !newDesc.isEmpty()) {
                            foundItem.setDescription(newDesc);
                        }
                    } else {
                        System.out.println("Заявка с ID: " + idItem + " не найдена!");
                    }
                }

            } else if (answer == 3) {

                String idItem = input.ask("Введите ID удаляемой заявки: ");
                if (!answerString.isEmpty()) {
                    Item foundItem;
                    if ((foundItem = tracker.findById(idItem)) != null) {
                        tracker.delete(foundItem);
                    } else {
                        System.out.println("Заявка с ID: " + idItem + " не найдена!");
                    }
                }

            } else if (answer == 7) {
                break;
            } else if (answer == 4) {
                System.out.println(" ------------------------------------- ");
                System.out.println();
                System.out.println(tracker);
                System.out.println();
                System.out.println(" ------------------------------------- ");
            } else if (answer == 5) {

                while (true) {

                    System.out.println("\n");
                    System.out.println("Выберите варинат поиска,");
                    System.out.println("1 - по наименованию");
                    System.out.println("2 - по ID");
                    System.out.println("3 - по дате создания");
                    System.out.println("4 - по наименованию и дате создания");
                    System.out.println("5 - выход");
                    System.out.println("\n");

                    answerString = input.ask("Введите вариант поиска: ");
                    if (answerString.isEmpty()) continue;

                    answer = Integer.parseInt(answerString);

                    if (answer == 1) {
                        String nameSelect = input.ask("Введите имя заявки: ");
                        if (nameSelect.isEmpty()) continue;

                        Item[] findItems = tracker.findByName(nameSelect);
                        if (findItems != null && findItems.length > 0) {
                            System.out.println("\n Найдено - " + findItems.length + " заявок:");
                            StringBuilder resalt = new StringBuilder();

                            for (Item item :
                                    findItems) {
                                Date date = new Date(item.getCreate());
                                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
                                resalt.append("Name: " + item.getName());
                                resalt.append(" дата создания: ");
                                resalt.append(format.format(date));
                                resalt.append(" ID: " + item.getId());
                                resalt.append(" description: " + item.getDescription());
                                resalt.append("\n");
                            }

                            System.out.println(resalt.toString());

                        } else {
                            System.out.println("Заявки с именем: " + nameSelect + ", не найдены!");
                            continue;
                        }
                    } else if (answer == 2) {

                        String idSelect = input.ask("Введите ID ");
                        if (idSelect.isEmpty()) continue;
                        Item findItem = tracker.findById(idSelect);
                        if (findItem != null) {
                            System.out.println("Найдена зявка с ID " + idSelect);
                            System.out.println(findItem.toString());
                        } else {
                            System.out.println("Заявки с ID: " + idSelect + ", не найдены!");
                            continue;
                        }
                    } else if (answer == 3) {
                        String dateSelect = input.ask("Введите дату в формате \"dd.MM.yyyy\": ");
                        DateValidator dateValidator = new DateValidator();

                        if (dateValidator.validate(dateSelect)) {
                            Item[] findItems = tracker.findByDate(dateSelect);
                            if (findItems != null && findItems.length > 0) {
                                System.out.println("\n Найдены заявки с датой - " + dateSelect + "\n");
                                for (Item item :
                                        findItems) {
                                    System.out.println(item);
                                }
                            } else {
                                System.out.println("Заявки с датой " + "\"dateSelect + \" не найдены!");
                            }

                        } else {
                            System.out.println("Вы ввели не корректную  дату!");
                            continue;
                        }

                    } else if (answer == 4) {

                        String nameSelect = input.ask("\nВведите имя заявки: ");
                        String dateSelect = input.ask("Введите дату в формате \"dd.MM.yyyy\" : ");
                        DateValidator dateValidator = new DateValidator();

                        if (nameSelect.isEmpty() || dateSelect.isEmpty()) {
                            System.out.println("Заявки с именем: "
                                    + nameSelect
                                    + " и датой "
                                    + "\"" + dateSelect + "\""
                                    + " не найдены!");
                        } else {

                            Item[] findItems = tracker.findByName(nameSelect);
                            if (findItems != null && findItems.length > 0) {

                                Tracker trackerBuff = new Tracker();
                                trackerBuff.setItems(findItems);

                                findItems = trackerBuff.findByDate(dateSelect);

                                if (findItems != null && findItems.length > 0) {
                                    System.out.println("\n Найдены заявки \n");
                                    for (Item item :
                                            findItems) {
                                        System.out.println(item);
                                    }
                                } else {
                                    System.out.println("Заявки с именем: "
                                            + nameSelect
                                            + " и датой "
                                            + "\"" + dateSelect + "\""
                                            + " не найдены!");
                                }

                            } else {
                                System.out.println("Заявки с именем: "
                                        + nameSelect
                                        + " и датой "
                                        + "\"" + dateSelect + "\""
                                        + " не найдены!");
                            }
                        }

                    } else if (answer == 5) break;

                }

            } else if (answer == 6) {
                String idItem = input.ask("Введите ID редактируемой заявки: ");
                if (!answerString.isEmpty()) {
                    Item foundItem;
                    if ((foundItem = tracker.findById(idItem)) != null) {
                        String newComment = input.ask("Введите новый комментарий: ");
                        if (newComment != null && !newComment.isEmpty()) {
                            foundItem.getComments().add(newComment);
                        }
                    } else {
                        System.out.println("Заявка с ID: " + idItem + " не найдена!");
                    }
                } else continue;
            } else System.out.println("Введенное значение не соответствуйте не одному из пунктов меню!");

        }

    }
}
