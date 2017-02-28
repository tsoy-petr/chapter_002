package ru.bildovich;

/**
 * Class Project.
 * @author bildovich.
 * @version 1.0.
 */
public class Project implements Specifics {

    /**
     * The name field.
     */
    private String name;

    /**
     * Constructor of Project class.
     * @param name the name.
     */
    public Project(String name) {
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
