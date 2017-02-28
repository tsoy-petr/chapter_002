package ru.bildovich;

/**
 * bildovich
 * 25.02.2017.
 */
public class Teacher extends Profession {

    private MyList pupils;
    private LessonSchedule lessonSchedule;
    private MyList specialization;

    public void addPupil(String namePupil) {

        pupils.add(new Pupil(namePupil));

    }

    public void deletPupils(String pupilName) {
        for (int i = 0; i < pupils.size(); ) {
            if (pupils.get(i).getName().equals(pupilName)) {
                pupils.remove(i);
            } else {
                i++;
            }
        }
    }

    public void setLessonSchedule(LessonSchedule lessonSchedule) {
        this.lessonSchedule = lessonSchedule;
    }

    public void СonductLesson() {

    }

    public void receiveSpecialization(String nameSpecialization) {
        specialization.add(new TeacherSpecialization(nameSpecialization));
    }

}
