package ru.bildovich;

/**
 * Class Teacher.
 *
 * @author bildovich.
 * @version 1.0.
 */
public class Teacher extends Profession {

    /**
     * The collection pupils.
     */
    private MyList pupils;

    /**
     * The collection lesson schedule.
     */
    private LessonSchedule lessonSchedule;

    /**
     * The collection specializations.
     */
    private MyList specialization;

    /**
     * Constructor class Doctor.
     *
     * @param name the name field.
     */
    public Teacher(String name) {
        super(name);
    }

    /**
     * Method to add pupil.
     *
     * @param namePupil the name.
     */
    public void addPupil(String namePupil) {

        if (pupils == null){
            pupils = new MyList();
        }

        pupils.add(new Pupil(namePupil));

    }

    /**
     * Method to delet pupil.
     *
     * @param pupilName the name.
     */
    public void deletPupils(String pupilName) {

        if (pupils == null){
            pupils = new MyList();
        }

        for (int i = 0; i < pupils.size();) {
            if (pupils.get(i).getName().equals(pupilName)) {
                pupils.remove(i);
            } else {
                i++;
            }
        }
    }

    /**
     * Setter method for name lessonSchedule.
     *
     * @param lessonSchedule the lessonSchedule field.
     */
    public void setLessonSchedule(LessonSchedule lessonSchedule) {
        this.lessonSchedule = lessonSchedule;
    }

    /**
     * Method for Lesson.
     */
    public void conductLesson() {

    }

    /**
     * Method add new specialization.
     *
     * @param nameSpecialization the name of the new specialization.
     */
    public void receiveSpecialization(String nameSpecialization) {
        specialization.add(new TeacherSpecialization(nameSpecialization));
    }

}
