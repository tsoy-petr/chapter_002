package ru.bildovich;

/**
 * @author bildovich.
 * @version 1.0.
 */
public class TeacherSpecialization implements Specialization, Specifics {

    /**
     * The name field.
     */
    private String name;

    /**
     * Constructor of TeacherSpecialization class.
     * @param name the name.
     */
    public TeacherSpecialization(String name) {
        this.name = name;
    }

    /**
     * Getter method for name field.
     * @return name.
     */
    @Override
    public String getName() {
        return name;
    }

}
