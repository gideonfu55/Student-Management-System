package service;

import java.util.*;

import model.Course;
import model.Student;
import repository.StudentRepository;

// This class actually combines both the Student 'repository' (with a Student HashMap) and Service layer (with business logic methods) all in one.
public class StudentService {

    StudentRepository studentRepository = new StudentRepository();
    HashMap<String, Student> students = studentRepository.retreiveStudents();

    // Basis of creating student in the system:
    public void subscribeStudent(Student student) {
        if (!students.containsKey(student.getPersonId())) {
            students.put(student.getPersonId(), student);
            System.out.println("\nStudent has been registered successfully!");
        } else {
            System.out.println("Student is already registered!");
        }
    }

    // Basis of retrieving student in the system:
    public Student findStudent(String personId) {
        if (students.containsKey(personId)) {
            Student student = students.get(personId);

            return student;
        }
        return null;
    }

    // Basis of adding a course (for enrollment) to a student:
    public boolean enrollToCourse(String personId, Course course) {
        if (students.containsKey(personId)) {
            students.get(personId).enrollToCourse(course);
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
