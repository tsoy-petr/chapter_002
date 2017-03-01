package ru.bildovich;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * bildovich
 * 01.03.2017.
 */
public class DoctorTest {

    /**
     * The doctorTest field.
     */
    private Doctor doctorTest;

    /**
     * Information method to test.
     */
    @Before
    public void infoForTest() {
        doctorTest = new Doctor("Кто");
    }

    /**
     * Test method add Patient class Doctor.
     */
    @Test
    public void whenAddNewPatient() {
        String checked = "Иванов";
        doctorTest.addPatient(checked);
        String result = doctorTest.getPatients().get(doctorTest.getPatients().size() - 1).getName();
        assertThat(result, is(checked));
    }

    /**
     * Test method delete Patient class Doctor.
     */
    @Test
    public void whenDelPatient(){
        String checked = "Иванов";
        doctorTest.addPatient(checked);
        doctorTest.delPatient(checked);
        assertThat(0, is(doctorTest.getPatients().size()));
    }
}
