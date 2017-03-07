package ru.bildovich;

/**
 * Class Doctor.
 *
 * @author bildovich.
 * @version 1.0.
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
     * Conctructor class Doctor.
     *
     * @param newName the name field.
     */
    public Doctor(String newName) {
        super(newName);
    }

    /**
     * Method to add patient.
     *
     * @param namePatient the name.
     */
    public void addPatient(String namePatient) {

        if (patients == null) {
            patients = new MyList();
        }
        patients.add(new Patient(namePatient));

    }

    /**
     * Method to delet patient.
     *
     * @param namePatient the name.
     */
    public void delPatient(String namePatient) {

        if (patients == null) {
            patients = new MyList();
        }

        for (int i = 0; i < patients.size(); ) {
            if (patients.get(i).getName().equals(namePatient)) {
                patients.remove(i);
            } else {
                i++;
            }
        }
    }

    /**
     * Returns a list of patients Method.
     *
     * @return list of patients.
     */
    public MyList getPatients() {
        return patients;
    }

    /**
     * Returns specialization Method.
     *
     * @return specialization field.
     */
    public MyList getSpecialization() {
        return specialization;
    }

    /**
     * Return result of cure.
     * @param patient field.
     * @return result boolean.
     */
    public boolean cure(Patient patient) {
        return true;
    }

}
