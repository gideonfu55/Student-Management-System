package service;

import java.util.*;

import model.Course;
import model.Student;

// This class actually combines both the Student 'repository' (with a Student HashMap) and Service layer (with business logic methods) all in one.
public class StudentService {

    private final HashMap<String, Student> students = new HashMap<>();

    public void subscribeStudent(Student student) {
        if (!students.containsKey(student.getName().toLowerCase() + student.getBirthDate())) {
            students.put(student.getName().toLowerCase() + student.getBirthDate(), student);
            System.out.println("\nStudent has been registered successfully!");
        } else {
            System.out.println("Student is already registered!");
        }
    }

    public Student findStudent(String studentName, String studentBirthDate) {
        if (students.containsKey(studentName.toLowerCase() + studentBirthDate)) {
            Student student = students.get(studentName.toLowerCase() + studentBirthDate);

            return student;
        }
        return null;
    }

    public boolean enrollToCourse(String studentName, String studentBirthDate, Course course) {
        if (students.containsKey(studentName.toLowerCase() + studentBirthDate)) {
            students.get(studentName.toLowerCase() + studentBirthDate).enrollToCourse(course);
            return true;
        }
        return false;
    }

    public boolean studentsRecordEmpty() {
        if (!students.isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String studentsRecord = "";
        for(Student student: students.values()) {
            studentsRecord += student;
        }
        return studentsRecord;
    }

}
