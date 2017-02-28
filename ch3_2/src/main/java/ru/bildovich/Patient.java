package ru.bildovich;

/**
 * bildovich
 * 28.02.2017.
 */
public class Patient implements Specifics {

    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
