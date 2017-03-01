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
     * Test method addPatient class Doctor.
     */
    @Test
    public void whenAddNewPatient() {
        String checked = "Иванов";
        doctorTest.addPatient(checked);
        String result = doctorTest.getPatients().get(doctorTest.getPatients().size() - 1).getName();
        assertThat(result, is(checked));
    }
}
