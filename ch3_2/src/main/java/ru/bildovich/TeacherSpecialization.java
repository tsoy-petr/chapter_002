package ru.bildovich;

/**
 * bildovich
 * 28.02.2017.
 */
public class TeacherSpecialization implements Specialization, Specifics {

    private String name;

    public TeacherSpecialization(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

}
