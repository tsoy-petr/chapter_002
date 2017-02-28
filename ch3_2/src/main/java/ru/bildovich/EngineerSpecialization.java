package ru.bildovich;

/**
 * @author bildovich.
 * @version 1.0.
 */
public class EngineerSpecialization implements Specialization, Specifics {

    /**
     * The name field.
     */
    private String name;

    /**
     * Getter method for name field.
     * @return name.
     */
    @Override
    public String getName() {
        return name;
    }
}
