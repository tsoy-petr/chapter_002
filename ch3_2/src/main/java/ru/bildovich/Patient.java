package ru.bildovich;

/**
 * bildovich
 * 28.02.2017.
 */
public class Patient implements Specifics {

    /**
     * The name field.
     */
    private String name;

    /**
     * Constructor of Doctor class.
     * @param name the name.
     */
    public Patient(String name) {
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
