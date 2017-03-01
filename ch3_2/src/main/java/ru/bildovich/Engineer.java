package ru.bildovich;

/**
 * Class Engineer.
 * @author bildovich.
 * @version 1.0.
 *
 */
public class Engineer extends Profession {

    /**
     * The projects field.
     */
    private MyList projects;

    /**
     * The specialization field.
     */
    private MyList specialization;

    /**
     * Constructor class Doctor.
     *
     * @param name the name field.
     */
    public Engineer(String name) {
        super(name);
    }

    /**
     *  Method to add project.
     * @param nameProject the name.
     */
    public void addProgect(String nameProject) {

        if (projects == null){
            projects = new MyList();
        }

        projects.add(new Project(nameProject));

    }

    /**
     * Method to delet project.
     * @param nameProject the name.
     */
    public void delProgect(String nameProject) {

        if (projects == null){
            projects = new MyList();
        }

        for (int i = 0; i < projects.size();) {
            if (projects.get(i).getName().equals(nameProject)) {
                projects.remove(i);
            } else {
                i++;
            }
        }
    }
}
