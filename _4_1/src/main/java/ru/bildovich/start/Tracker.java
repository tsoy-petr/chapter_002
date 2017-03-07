package ru.bildovich.start;

import ru.bildovich.models.Item;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by mac on 04.03.17.
 */
public class Tracker {


    /**
     * Private items field.
     */
    private Item[] items;

    /**
     * The size field.
     */
    private int size = 0;

    /**
     * Method add new item.
     *
     * @param item new item.
     * @return added item.
     */
    public Item add(Item item) {

        if (this.items == null) {
            this.items = new Item[1];
        } else {
            Item[] temp = new Item[size + 1];
            arrayCopy(this.items, 0, temp, 0, size);
            this.items = temp;
        }

        this.items[size] = item;
        size++;
        return item;
    }

    /**
     * Method deleting item.
     *
     * @param item deleting.
     */
    public void delete(Item item) {
        int index = this.getIndexById(item.getId());
        if (index >= 0) {

            if (this.items == null) {
                this.items = new Item[1];
            } else {

                Item[] temp = new Item[size == 1 ? 1 : size - 1];
                arrayCopy(this.items, 0, temp, 0, index);
                arrayCopy(this.items, index + 1, temp, index, this.items.length);
                this.items = temp;
                this.size--;

            }

        }
    }

    /**
     * Method replacing a cell in the items.
     *
     * @param item for update.
     */
    public void update(Item item) {
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(item.getId())) {
                this.items[i] = item;
                break;
            }
        }
    }

    /**
     * Не очень понял в задании смысл этого метода.
     *
     * @return items field.
     */
    public Item[] findAll() {
        return this.items;
    }

    /**
     * Search of items by name.
     *
     * @param key search.
     * @return massif by items.
     */
    public Item[] findByName(String key) {

        Tracker buff = new Tracker();

        for (Item item : this.items
                ) {
            if (item.getName().equals(key)) {
                buff.add(item);
            }
        }

        return buff.getItems();

    }

    /**
     * Search of item by id.
     *
     * @param id search.
     * @return item.
     */
    public Item findById(String id) {
        for (Item item : this.items
                ) {
            if (item != null && item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    /**
     * Method for copying arrays.
     *
     * @param from      the source array.
     * @param fromIndex the initial index.
     * @param to        an array receiver.
     * @param toIndex   end index.
     * @param length    the length of the source array.
     */
    private void arrayCopy(Item[] from,
                           int fromIndex,
                           Item[] to,
                           int toIndex,
                           int length) {

        for (int i = fromIndex; i < length; i++, toIndex++) {
            to[toIndex] = from[i];
        }

    }

    /**
     * Getter size field.
     *
     * @return size field.
     */
    public int getSize() {
        return size;
    }

    /**
     * Getter items.
     *
     * @return items.
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * Method getIndexById.
     * @param id item.
     * @return index.
     */
    public int getIndexById(String id) {

        for (int i = 0; i < items.length; i++) {
            if (items[i].getId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Override method.
     * @return string field.
     */
    @Override
    public String toString() {
        StringBuilder resalt = new StringBuilder();

        for (Item item:
             items) {
            Date date = new Date(item.getCreate());
            SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
            resalt.append(item.getName());
            resalt.append(" дата создания: ");
            resalt.append(format.format(date));
            resalt.append("\n");
        }

        return resalt.toString();
    }
}

