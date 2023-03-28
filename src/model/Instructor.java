package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Instructor extends Person {

    private int experienceMonths;

    private final List<Course> coursesInstructed = new ArrayList<>();

    protected Instructor(String personId, String name, String email, Date birthDate) {
        super(personId, name, email, birthDate);
    }

    public int getExperienceMonths() {
        return experienceMonths;
    }

    public void setExperienceMonths(int experienceMonths) {
        this.experienceMonths = experienceMonths;
    }

    public List<Course> getCoursesInstructed() {
        return coursesInstructed;
    }

    @Override
    public String toString() {
        return "{" +
            " experienceMonths='" + getExperienceMonths() + "'" +
            ", coursesInstructed='" + getCoursesInstructed() + "'" +
            "}";
    }

}
