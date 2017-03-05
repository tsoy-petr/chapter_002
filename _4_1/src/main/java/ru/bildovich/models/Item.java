package ru.bildovich.models;

import java.util.ArrayList;
import java.util.UUID;

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
     * Private "description" field.
     */
    private String description;

    /**
     * Private "date create" field.
     */
    private long create;

    /**
     * Private String desc.
     */
    private String desc;

    /**
     * Private array list comments;
     */
    private ArrayList<String> comments;

    /**
     * Constructor Item class.
     */
    public Item() {
        this.id = UUID.randomUUID().toString();
        this.create = System.currentTimeMillis();
    }

    /**
     * Constructor Item class.
     * @param id field.
     * @param name field.
     */
    public Item(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Item(String name){
        this();
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
