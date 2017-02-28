package ru.bildovich;

/**
 * bildovich
 * 25.02.2017.
 */
public class Doctor extends Profession {

    private MyList patients;
    private MyList specialization;

    public void addProgect(String nameProject) {

        patients.add(new Patient(nameProject));

    }

    public void delProgect(String pupilName) {
        for (int i = 0; i < patients.size(); ) {
            if (patients.get(i).getName().equals(pupilName)) {
                patients.remove(i);
            } else {
                i++;
            }
        }
    }
}
