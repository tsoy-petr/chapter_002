package ru.bildovich;

/**
 * Class Pupil.
 * @author bildovich.
 * @version 1.0.
 */
public class Pupil implements Specifics{

    private String name;

    public Pupil(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
