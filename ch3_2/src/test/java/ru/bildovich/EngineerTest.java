package ru.bildovich;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * bildovich
 * 01.03.2017.
 */
public class EngineerTest {

    /**
     * The engineerTest field.
     */
    private Engineer engineerTest;

    /**
     * Information method to test.
     */
    @Before
    public void infoForTest() {
        engineerTest = new Engineer("Кнопка");
    }

    /**
     * Test method add project class Engineer.
     */
    @Test
    public void whenAddNewPatient() {
        String checked = "job4j.ru";
        engineerTest.addProgect(checked);
        String result = engineerTest.getProjects().get(engineerTest.getProjects().size() - 1).getName();
        assertThat(result, is(checked));
    }

    /**
     * Test method delete project class Engineer.
     */
    @Test
    public void whenDelPatient(){
        String checked = "job4j.ru";
        engineerTest.addProgect(checked);
        engineerTest.delProgect(checked);
        assertThat(0, is(engineerTest.getProjects().size()));
    }

    @Test
    public void executeProjectTest() {
        boolean result = engineerTest.executeProject(new Project("Robot creation"));
        assertThat(true, is(result));
    }
}
