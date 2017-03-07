package ru.bildovich;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * bildovich
 * 01.03.2017.
 */
public class TeacherTest {

    /**
     * The teacherTest field.
     */
    private Teacher teacherTest;

    /**
     * Information method to test.
     */
    @Before
    public void infoForTest() {
        teacherTest = new Teacher("Училкина");
    }

    /**
     * Test method add pupil.
     */
    @Test
    public void whenAddNewPatient() {
        String checked = "Иванов";
        teacherTest.addPupil(checked);
        String result = teacherTest.getPupils().get(teacherTest.getPupils().size() - 1).getName();
        assertThat(result, is(checked));
    }

    /**
     * Test method delete pupil.
     */
    @Test
    public void whenDelPatient(){
        String checked = "Иванов";
        teacherTest.addPupil(checked);
        teacherTest.addPupil("Петров");
        teacherTest.deletPupils(checked);
        assertThat(1, is(teacherTest.getPupils().size()));
    }

    /**
     * Test method teach.
     */
    @Test
    public void teachTest() {
        boolean result = teacherTest.teach(new Pupil("Ivanov"));
        assertThat(true, is(result));

    }
}
