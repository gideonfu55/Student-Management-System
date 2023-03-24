package model;

import java.util.List;

public interface Evaluation {

    List<Course> getPassedCourses();
    List<Course> getFailedCourses();
    List<Course> getEnrolledCourses();
    
}
