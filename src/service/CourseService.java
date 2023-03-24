package service;

import model.Course;
import model.Module;

import java.util.LinkedHashMap;
import java.util.Map;

// Combination of CourseService methods and CourseRepository
public class CourseService {

    private final Map<String, Course> courses = new LinkedHashMap<>();

    public CourseService() {
    
        //Multiple courses belongs to a Module
        Module moduleCS = new Module("INTRO-CS", "Introduction to Computer Science", 
                                     "Introductory module for the generation technical programs");

        registerCourse(new Course("INTRO-CS-1", "Introduction to Computer Science", 9, moduleCS));
        registerCourse(new Course("INTRO-CS-2", "Introduction to Algorithms", 9, moduleCS));
        registerCourse(new Course("INTRO-CS-3", "Algorithm Design and Problem Solving - Introduction", 9, moduleCS));
        registerCourse(new Course("INTRO-CS-4", "Algorithm Design and Problem Solving - Advanced", 9, moduleCS));
        registerCourse(new Course("INTRO-CS-5", "Terminal Fundamentals", 9, moduleCS));
        registerCourse(new Course("INTRO-CS-6", "Source Control Using Git and Github", 9, moduleCS));
        registerCourse(new Course("INTRO-CS-7", "Agile Software Development with SCRUM", 9, moduleCS));


        Module moduleWebDev = new Module("INTRO-WEB", "Web Development Fundamentals",
                                         "Introduction to fundamentals of web development");

        registerCourse(new Course("INTRO-WEB-1", "Introduction to Web Applications", 9, moduleWebDev));
        registerCourse(new Course("INTRO-WEB-2", "Introduction to HTML", 9, moduleWebDev));
        registerCourse(new Course("INTRO-WEB-3", "Introduction to CSS", 9, moduleWebDev));
        registerCourse(new Course("INTRO-WEB-4", "Advanced HTML", 9, moduleWebDev));
        registerCourse(new Course("INTRO-WEB-5", "Advanced CSS", 9, moduleWebDev));
        registerCourse(new Course("INTRO-WEB-6", "Introduction to Bootstrap Framework", 9, moduleWebDev));
        registerCourse(new Course("INTRO-WEB-7", "Introduction to JavaScript for Web Development", 9, moduleWebDev));

    }

    public void registerCourse(Course course) {
        courses.put(course.getCourseId(), course);
    }

    public Course getCourseById(String courseId) {
        if (courses.containsKey(courseId)) {
            return courses.get(courseId);
        }
        return null;
    }

    public void showSummary() {
        System.out.println("\nAvailable Courses:");
        for (String key : courses.keySet()) {
            Course course = courses.get(key);
            System.out.println(course);
        }
    }
    
}
