package ru.bildovich;

/**
 * Created by mac on 01.03.17.
 */
public class Item {

    /**
     * Private "id" field.
     */
    private String id;

    /**
     * Private "name" field.
     */
    private String name;

    /**
     * Constructor Item class.
     * @param id field.
     * @param name field.
     */
    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Getter id field.
     * @return id field.
     */
    public String getId() {
        return id;
    }

    /**
     * Setter id field.
     * @param id field.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Getter name field.
     * @return name field.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter name field.
     * @param name field.
     */
    public void setName(String name) {
        this.name = name;
    }

}
