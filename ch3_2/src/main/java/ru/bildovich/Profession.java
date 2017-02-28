package ru.bildovich;

/**
 * bildovich
 * 25.02.2017.
 */
public class Profession {

    private String name;
    private String telephone;
    private String adress;
    private String email;
    private double salary;

    private Specialization specialization;

    public void receiveSpecialization(Specialization specialization){
        this.specialization = specialization;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }
}
