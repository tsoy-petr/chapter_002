package ru.bildovich;

/**
 * Class MyList.
 * @author bildovich.
 * @version 1.0.
 */
public class MyList {

    /**
     * The value field.
     */
    private Specifics[] values;

    /**
     * The size field.
     */
    private int size = 0;

    /**
     * Method to add new values.
     * @param newValues the new values.
     */
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

    /**
     * The method removes the element at index.
     * @param index of the element to remove.
     * @return element of the values.
     */
    public Specifics remove(int index) {

        /**
         * Deleted item
         */
        Specifics removeElement = null;

        /**
         * Check the output for the collection of the border.
         */
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

    /**
     * Method for copying arrays.
     * @param from the source array.
     * @param fromIndex the initial index.
     * @param to an array receiver.
     * @param toIndex end index.
     * @param length the length of the source array.
     */
    private void arrayCopy(Specifics[] from,
                          int fromIndex,
                          Specifics[] to,
                          int toIndex,
                          int length) {

        for (int i = fromIndex; i < length; i++, toIndex++) {
            to[toIndex] = from[i];
        }

    }

    /**
     * Getter method for size field.
     * @return size.
     */
    public int size() {
        return size;
    }

    /**
     * Getter method for values.
     * @param i the index.
     * @return specifics.
     */
    public Specifics get(int i) {
        return values[i];
    }
}
