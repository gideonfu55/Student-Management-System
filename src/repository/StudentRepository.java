package repository;

import java.util.HashMap;

import model.Student;

public class StudentRepository {
  
  private final HashMap<String, Student> students = new HashMap<>();

  public void createStudent(Student student) {
    this.students.put(student.getPersonId(), student);
  }

  public Student retreiveStudent(String id) {
    return this.students.get(id);
  }

  public HashMap<String, Student> retreiveStudents() {
    return students;
  }

  public void updateStudent(Student student) {
    this.students.put(student.getPersonId(), student);
  }

  public void deleteStudent(String id) {
    this.students.remove(id);
  }

}
