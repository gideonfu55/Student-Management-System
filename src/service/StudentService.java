package service;

import model.Course;
import model.Student;
import repository.StudentRepository;

// This class actually combines both the Student 'repository' (with a Student HashMap) and Service layer (with business logic methods) all in one.
public class StudentService {

    StudentRepository studentRepository = new StudentRepository();

    // Basis of creating student in the system:
    public void subscribeStudent(Student student) {
        if (!studentRepository.retrieveStudents().containsKey(student.getPersonId())) {
            studentRepository.createStudent(student);
            System.out.println("\nStudent has been registered successfully!");
        } else {
            System.out.println("Student is already registered!");
        }
    }

    // Basis of retrieving student in the system:
    public Student findStudent(String personId) {
        if (studentRepository.retrieveStudent(personId) != null) {
            Student student = studentRepository.retrieveStudent(personId);

            return student;
        }
        return null;
    }

    // Basis of adding a course (for enrollment) to a student:
    public boolean enrollToCourse(String personId, Course course) {
        if (studentRepository.retrieveStudent(personId) != null) {
            studentRepository.retrieveStudent(personId).enrollToCourse(course);
            return true;
        }
        return false;
    }

    public boolean studentsRecordEmpty() {
        if (!studentRepository.retrieveStudents().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String studentsRecord = "";
        for(Student student: studentRepository.retrieveStudents().values()) {
            studentsRecord += student;
        }
        return studentsRecord;
    }

}
