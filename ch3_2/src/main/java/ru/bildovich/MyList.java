package ru.bildovich;

/**
 * bildovich
 * 28.02.2017.
 */
public class MyList {

    private Specifics[] values;
    private int size = 0;

    public void add(Specifics newValues) {

        if (values == null) {
            values = new Specifics[1];
        } else {
            Specifics[] temp = new Specifics[size + 1];
            arrayCopy(values, 0, temp, 0, size);
            values = temp;
        }

        values[size] = newValues;
        size++;

    }

    public Specifics remove(int index) {

        Specifics removeElement = null;

        // Проверка на выход за границы коллекции
        if (index < 0 || index > size) {
            return removeElement;
        }

        if (values == null) {
            values = new Specifics[1];
        } else {
            Specifics[] temp = new Specifics[size == 1 ? 1 : size - 1];
            removeElement = values[index];
            arrayCopy(values, 0, temp, 0, index);
            arrayCopy(values, index + 1, temp, index, values.length);
            values = temp;
            size--;
        }

        return removeElement;
    }

    public void clear() {

        for (int i = 0; i < size; i++)
            values[i] = null;

        size = 0;
    }

    public void arrayCopy(Specifics[] from,
                          int fromIndex,
                          Specifics[] to,
                          int toIndex,
                          int length) {

        for (int i = fromIndex; i < length; i++, toIndex++) {
            to[toIndex] = from[i];
        }

    }

    public int size() {
        return size;
    }

    public Specifics get(int i) {
        return values[i];
    }
}
