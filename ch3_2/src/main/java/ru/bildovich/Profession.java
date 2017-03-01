package ru.bildovich;

/**
 * Class Profession.
 * @author bildovich.
 * @version 1.0.
 */
public class Profession {

    /**
     * The name field.
     */
    private String name;

    /**
     * The telephone field.
     */
    private String telephone;

    /**
     * The adress field.
     */
    private String adress;

    /**
     * The email field.
     */
    private String email;

    /**
     * The salary field.
     */
    private double salary;

    /**
     * The specialization field.
     */
    private Specialization specialization;

    /**
     * Constructor class Doctor.
     * @param name the name field.
     */
    public Profession(String name) {
        this.name = name;
    }

    /**
     * Settor method for specialization field.
     * @param specialization the specialization field.
     */
    public void receiveSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    /**
     * Settor method for salary field.
     * @param salary the salary field.
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

}
