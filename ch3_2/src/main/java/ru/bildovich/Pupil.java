package ru.bildovich;

/**
 * Class Pupil.
 *
 * @author bildovich.
 * @version 1.0.
 */
public class Pupil implements Specifics {

    /**
     * The name field.
     */
    private String name;

    /**
     * Constructor of Pupil class.
     * @param name the name.
     */
    public Pupil(String name) {
        this.name = name;
    }

    /**
     * Getter method for name field.
     * @return name.
     */
    public String getName() {
        return name;
    }
}
