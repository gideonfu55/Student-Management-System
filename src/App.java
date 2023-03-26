import java.text.ParseException;
import java.util.Scanner;

import model.Course;
import model.Student;
import model.validator.PersonValidator;
import service.CourseService;
import service.StudentService;
import utils.MenuPrinter;

public class App {
    public static void main(String[] args) throws ParseException, IllegalArgumentException {

        StudentService studentService = new StudentService();
        CourseService courseService = new CourseService();
        PersonValidator studentValidator = new PersonValidator();

        Scanner scanner = new Scanner(System.in);
        int option;

        do {
            MenuPrinter.showMainMenu();

            while (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number between 1-8.");
                scanner.next();
            }

            option = scanner.nextInt();
            MenuPrinter.printMenuHeader(option);

            switch (option) {

                case 1:
                    registerStudent(studentService, scanner, studentValidator);
                    break;

                case 2:
                    printStudentRecord(studentService, scanner);
                    break;

                case 3:
                    enrollCourse(studentService, courseService, scanner);
                    break;

                case 4:
                    gradeStudent(studentService, courseService, scanner);
                    break;

                case 5:
                    showStudentsSummary(studentService, scanner);
                    break;

                case 6:
                    showCoursesSummary(courseService, scanner);
                    break;

                case 7:
                    showPassedCourses(studentService, scanner);
                    break;

                case 8:
                    System.out.println("\nThank you for using StudentGen. Goodbye!\n");
                    System.exit(0);

                default:
                    System.out.println("Please enter a valid option from 1-8");
            }

        }
        while (option >= 0);
    }

    /**
     * ===========================================================================
     * Methods for Student Management System Menu according to its selection order
     * ===========================================================================
     */
    /**
     * Function name: registerStudent
     * 
     * @param studentService
     * @param scanner
     * @throws ParseException
     * 
     * 1. Creates a Student object with PrinterHelper's createStudentMenu
     * 2. Use StudentService's subscribeStudent method to add student object to Students Hashmap 
     * (acting as the repository here).
     *
     */
    private static void registerStudent(StudentService studentService, Scanner scanner,
            PersonValidator studentValidator) throws ParseException {

        Student student = MenuPrinter.createStudentMenu(scanner, studentValidator);
        studentService.subscribeStudent(student);

    }

    /**
     * Function name: printStudentRecord
     * 
     * @param studentService
     * @param scanner
     * 
     *  Get student from StudentService and:
     *  1. Prints student information if student is found, or
     *  2. Prints not found message if otherwise.
     * 
     */
    private static void printStudentRecord(StudentService studentService, Scanner scanner) {

        Student student = getStudentInformation(studentService, scanner);

        if (student == null) {
            System.out.println("\nStudent not found. Please recheck that student is registered and/or info entered is valid.");
        } else {
            System.out.println("\nStudent found!");
            System.out.println(student);
        }
    }

    /**
     * Function Name: enrollCourse
     * 
     * @param studentService
     * @param courseService
     * @param scanner
     * 
     * Within Function:
     * 1. Get student information with required name and birth date using getStudentInformation().
     * 2. If present, prompt course ID to get Course object and use enrollToCourse method in student.
     * 3. If studentID AND/OR courseID is not present, respond with error message and return.
     *    - If student is already enrolled in Course, respond with error message.
     * 4. Call StudentService enrollToCourse method with student and course parameters.
     * 5. Print course enrollment successful/unsuccessful message.
     * 
     */
    private static void enrollCourse(StudentService studentService, CourseService courseService, Scanner scanner) {

        Student student = getStudentInformation(studentService, scanner);

        if (student == null) {
            System.out.println("\nStudent not found. Please recheck that student is registered and/or info entered is valid.");
            return;
        }

        System.out.println("\nStudent selected for course enrollment: " + "\n" + student);
        courseService.showSummary();
        System.out.println("\nEnter Course ID for enrollment: ");
        String courseId = scanner.next();

        Course course = courseService.getCourseById(courseId);

        if (course == null) {
            System.out.println("\nInvalid Course ID entered.");
            return;
        } else if (student.getEnrolledCourse(courseId) != null) {
            System.out.println("\nSelected student is already enrolled in this course. Please select another course for enrollment.");
            return;
        }

        System.out.println("\nCourse selected for enrollment: " + "\n" + course);

        if (studentService.enrollToCourse(student.getName(), student.getBirthDate(), new Course(course))) {
            System.out.println("\n" + student.getName() + " has been enrolled successfully to: \n<" + course.getCourseId() + "> " + course.getName());
        } else {
            System.out.println("Sorry, the course enrollment was unsuccessful.");
        };

    }

    /**
     * Function name: gradeStudent
     * 
     * @param studentService
     * @param scanner
     * 
     * 1. Return student to be graded with getStudentInformation().
     * 2. Print list of courses for student.
     * 3. Print message for entering Course ID and find course by ID.
     * 4. If course ID enter is not for an enrolled course, print error message and return to menu.
     * 5. Print message for entering Course Grade, validate input according to min and max grades, and 
     *    set grade if valid.
     * 
     */
    private static void gradeStudent(StudentService studentService, CourseService courseService, Scanner scanner) {

        Student student = getStudentInformation(studentService, scanner);

        if (student == null) {
            System.out.println("\nStudent not found. Please recheck that student is registered and/or info entered is valid.");
            return;
        }

        System.out.println("\nList of enrolled course(s): ");
        System.out.println(student.printEachCourse(student.getEnrolledCourses()));

        if (student.getEnrolledCourses().size() == 0) {
            System.out.println("\nThis Student is not enrolled in any course currently. Please enroll the student in a course before grading.");
            return;
        }

        System.out.println("\nList of ungraded course(s): ");

        int ungradedCourseCount = 0;
        for (Course course : student.getEnrolledCourses()) {
            if (course.getGrade() == 0) {
                System.out.println(course);
                ungradedCourseCount += 1;
            }
        }

        if (ungradedCourseCount == 0) {
            System.out.println("None. \nPlease select an enrolled course to be regraded if necessary.");
        }

        System.out.println("\nEnter Course ID to be graded/regraded:");
        String courseID = scanner.next();

        if (courseService.getCourseById(courseID) == null) {
            System.out.println("\nThe course ID entered is invalid. Please enter a valid course ID.");
            return;
        }

        Course course = student.getEnrolledCourse(courseID);

        if (course == null) {
            System.out.println("\nThe student is not enrolled to this course currently. Please enroll student before selecting course to grade.");
            return;
        }

        System.out.println("\nInsert course grade (1.0 to 6.0) for " + course.getName() + ": ");

        if (scanner.hasNextDouble()) {
            double grade = scanner.nextDouble();

            if (grade < course.MIN_GRADE || grade > course.MAX_GRADE) {
                System.out.println("\nSorry, please enter a valid grade between 0.0 & 6.0.");
                return;
            } else {
                course.setGrade(grade);
                System.out.println(
                    "\nThe course has been graded successfully: \n"
                    + "Student name: " + student.getName() + " - [ "
                    + "Enrolled Course: " + course.getName() + " - "
                    + "Grade received: " + course.getGrade() + " ]"
                );
            }

        } else {
            System.out.println("\nYour input is not a number. Please enter a valid number for grade submission.");
            scanner.next();
        }

    }

    /**
     * Function name: showStudentsSummary
     * 
     * @param studentService
     * @param scanner
     * 
     * 1. Print all Student records. If no records available, print notification message.
     * 2. Provide input option to return to main menu.
     * 
     */
    private static void showStudentsSummary(StudentService studentService, Scanner scanner) {

        if (!studentService.studentsRecordEmpty()) {
            System.out.println("\nNo students are registered currently.");
        } else {
            System.out.println(studentService + "\n");
        }

        System.out.println("\nEnter any key to return to main menu");
        scanner.next();
        // MenuPrinter.pressEnterToContinue();

    }

    /**
     * Function name: showCoursesSummary
     * 
     * @param courseService
     * @param scanner
     * 
     * 1. Print all Courses.
     * 2. Provide input option to return to main menu.
     * 
     */
    private static void showCoursesSummary(CourseService courseService, Scanner scanner) {

        courseService.showSummary();

        System.out.println("\nEnter any key to return to main menu");
        scanner.next();

        // MenuPrinter.pressEnterToContinue();
    }

    /**
     * Function name: showPassedCourses
     * 
     * @param studentService
     * @param scanner
     * 
     * 1. Find student object based on name and birth date. Return message if student is not found.
     * 2. If student is found, check if there are passed courses.
     * 3. Return list of passed courses if available.
     * 
     */
    private static void showPassedCourses(StudentService studentService, Scanner scanner) {

        System.out.println("Enter student's name: ");
        scanner.nextLine();
        String studentName = scanner.nextLine();

        System.out.println("\nEnter student's birth date: ");
        String studentBirthDate = scanner.next();

        Student student = studentService.findStudent(studentName, studentBirthDate);

        if (student == null) {
            System.out.println("\nStudent not found. Please recheck that student is registered and/or info entered is valid.");
        } else {
            if (student.getPassedCourses().size() == 0) {
                System.out.println("\nNo passed courses available. Please grade a course OR enroll student in a course for grading.");
            } else {
                System.out.println("\nList of courses " + student.getName() + " has passed: ");
                System.out.println(student.printEachCourse(student.getPassedCourses()));
            }
        }
    }

    /**
     * Function name: getStudentInformation
     * 
     * @param studentService
     * @param scanner
     * @return
     * 
     * 1. Scan for student name and birth date inputs - for checking hashCode key in students hashmap.
     * 2. Return student object based on studentService's findStudent function.
     * 
     */
    private static Student getStudentInformation(StudentService studentService, Scanner scanner) {

        System.out.println("Enter student's name: ");
        scanner.nextLine();
        String studentName = scanner.nextLine();

        System.out.println("\nEnter student's birth date: ");
        String studentBirthDate = scanner.next();

        Student student = studentService.findStudent(studentName, studentBirthDate);
        return student;

    }
}
