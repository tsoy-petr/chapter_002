package ru.bildovich;

/**
 * bildovich
 * 25.02.2017.
 */
public class Engineer extends Profession {

    private MyList projects;
    private MyList specialization;

    public void addProgect(String nameProject) {

        projects.add(new Project(nameProject));

    }

    public void delProgect(String pupilName) {
        for (int i = 0; i < projects.size(); ) {
            if (projects.get(i).getName().equals(pupilName)) {
                projects.remove(i);
            } else {
                i++;
            }
        }
    }
}
