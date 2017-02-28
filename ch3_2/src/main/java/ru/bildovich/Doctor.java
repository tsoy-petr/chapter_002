package ru.bildovich;

/**
 * Class Doctor.
 * @author bildovich.
 * @version 1.0.
 *
 */
public class Doctor extends Profession {

    /**
     * The collection patients.
     */
    private MyList patients;

    /**
     * The collection specializations.
     */
    private MyList specialization;

    /**
     *  Method to add patient.
     * @param namePatient the name.
     */
    public void addProgect(String namePatient) {

        patients.add(new Patient(namePatient));

    }

    /**
     * Method to delet patient.
     * @param namePatient the name.
     */
    public void delProgect(String namePatient) {
        for (int i = 0; i < patients.size();) {
            if (patients.get(i).getName().equals(namePatient)) {
                patients.remove(i);
            } else {
                i++;
            }
        }
    }
}
