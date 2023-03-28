package repository;

import java.util.LinkedHashMap;
import java.util.Map;

import model.Course;

public class CourseRepository {

  private final Map<String, Course> courses = new LinkedHashMap<>();

  public void createCourse(Course course) {
    courses.put(course.getCourseId(), course);
  }

  public Course retreiveCourse(String courseId) {
    return courses.get(courseId);
  }

  public Map<String, Course> retrieveCourses() {
    return courses;
  }

  public void updateCourse(Course course) {
    courses.put(course.getCourseId(), course);
  }

  public void deleteStudent(String courseId) {
    courses.remove(courseId);
  }
  
}
