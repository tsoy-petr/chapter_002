package ru.bildovich.models;

import java.text.SimpleDateFormat;
import java.util.*;

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
     * Private array list comments;
     */
    private ArrayList<String> comments;

    /**
     * Constructor Item class.
     */
    public Item() {
        this.id = UUID.randomUUID().toString();
        this.create = System.currentTimeMillis();
        this.description = "";
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

    public Item(String id, String name, String description, long create) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.create = create;
        this.comments = new ArrayList<String>();
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

    public long getCreate() {
        return create;
    }

    /**
     * Setter name field.
     * @param name field.
     */
    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getComments() {
        return comments;
    }

    public void setComments(ArrayList<String> comments) {
        this.comments = comments;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {

        StringBuilder resalt = new StringBuilder();

        Date date = new Date(this.create);
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        resalt.append("Name: " + this.name);
        resalt.append(" дата создания: ");
        resalt.append(format.format(date));
        resalt.append(" ID: " + id);
        resalt.append(" description: " + description);
        resalt.append("\n");

        if (comments != null && comments.size() > 0) {
            resalt.append(" Комментарии: \n");
            for (String comment :
                    comments) {
                resalt.append("     " + comment + "\n");
            }
        }

        resalt.append("\n");

        return resalt.toString();

    }

    public void edite(Item item) {

    }


}
