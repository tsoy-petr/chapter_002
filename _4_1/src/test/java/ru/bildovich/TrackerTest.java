package ru.bildovich;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.UUID;

/**
 * Created by mac on 02.03.17.
 */
public class TrackerTest {

    /**
     * The trackerTest field.
     */
    private Tracker trackerTest;

    /**
     * Information method to test.
     */
    @Before
    public void infoForTest() {
        trackerTest = new Tracker();
    }

    /**
     * Test method add.
     */
    @Test
    public void whenAddNewItem() {

        Item temp = new Item(UUID.randomUUID().toString(), "Заявказ клиента");
        Item result = trackerTest.add(temp);
        assertThat(result, is(temp));
    }

    /**
     * Test method delete.
     */
    @Test
    public void whenDeleteItem() {
        String id = UUID.randomUUID().toString();
        Item temp = new Item(id, "Заявказ клиента");
        trackerTest.add(temp);
        trackerTest.delete(temp);
        assertThat(null, is(trackerTest.findById(id)));
    }

    /**
     * Test method findAll.
     */
    @Test
    public void findAllTest() {
        String id = UUID.randomUUID().toString();
        Item temp = new Item(id, "Заявказ клиента");
        trackerTest.add(temp);
        assertThat(trackerTest.getItems(), is(trackerTest.getItems()));
    }


    /**
     * Test method update.
     */
    @Test
    public void updateTest() {
        String id = UUID.randomUUID().toString();
        Item temp1 = new Item(id, "Заявказ клиента 1");
        Item temp2 = new Item(id, "Заявказ клиента 2");
        trackerTest.add(temp1);
        trackerTest.update(temp2);
        assertThat(trackerTest.getItems()[0], is(temp2));
    }

    /**
     * Test method findByName.
     */
    @Test
    public void findByNameTest() {
        Item temp1 = new Item("1", "Заявказ клиента 1");
        Item temp2 = new Item("2", "Заявказ клиента 1");
        Item[] items = {temp1, temp2};
        trackerTest.add(temp1);
        trackerTest.add(temp2);
        Item[] result = trackerTest.findByName("Заявказ клиента 1");
        assertThat(result.length, is(items.length));
    }

    /**
     * Test method findById.
     */
    @Test
    public void findByIdTest() {
        String id = UUID.randomUUID().toString();
        Item temp1 = new Item(id, "Заявказ клиента 1");
        trackerTest.add(temp1);
        Item result = trackerTest.findById(id);
        assertThat(result, is(temp1));
    }
}
