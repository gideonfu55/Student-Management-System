package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.Student;
import model.validator.PersonValidator;

public class MenuPrinter {

    public static void showMainMenu() {

        System.out.println("\n");
        System.out.println("|------------------------------------------|");
        System.out.println("| Welcome to StudentGen:                   |");
        System.out.println("| Generation's Student Management System   |");
        System.out.println("|------------------------------------------|");
        System.out.println("| Select 1 option:                         |");
        System.out.println("| . 1 Register Student                     |");
        System.out.println("| . 2 Find Student                         |");
        System.out.println("| . 3 Enroll Student to Course             |");
        System.out.println("| . 4 Grade/Regrade Student                |");
        System.out.println("| . 5 Show Students Summary                |");
        System.out.println("| . 6 Show Courses Summary                 |");
        System.out.println("| . 7 Show Passed Courses (by Student)     |");
        System.out.println("| . 8 Exit Menu                            |");
        System.out.println("|__________________________________________|");
    }

    public static Student createStudentMenu(Scanner inputScan, PersonValidator studentValidator) throws ParseException, IllegalArgumentException {

        Student student = retreiveStudentInputs(inputScan, studentValidator);

        System.out.println("|-----------------------------------------------|");
        
        System.out.println(student);
        return student;
    }

    public static Student retreiveStudentInputs(Scanner inputScan, PersonValidator studentValidator) throws ParseException, IllegalArgumentException {

        System.out.println("| Enter student's personal ID:                  |");
        String personId = inputScan.next();

        System.out.println("| Enter student's name (all uppercase):         |");
        inputScan.nextLine();
        String name = inputScan.nextLine();

        while (studentValidator.nameValidator(name)) {
            System.out.println("  Please enter a valid name: ");
            name = inputScan.nextLine();
        }

        System.out.println("| Enter email: <enter>@mymail.generation.edu.sg |");
        String email = inputScan.next();

        while (studentValidator.emailValidator(email)) {
            System.out.println("  Please enter a valid email without @domain: ");
            email = inputScan.next();
        }

        System.out.println("| Enter student's birth date (dd/MM/yyyy):      |");
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        Date birthDate = null;
        while (studentValidator.birthDateValidator(birthDate)) {
            try {
                birthDate = formatter.parse(inputScan.next());
            } catch (ParseException e) {
                System.out.println("Please enter the valid date format in MM/dd/yyyy.");
            }
        }

        return new Student(personId, name, email, birthDate);
    }

    public static void pressEnterToContinue() {
        System.out.println("\nPress \"ENTER\" to continue...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        scanner.close();
    }

    public static void printMenuHeader(int option) {

        System.out.println("\n");

        switch (option) {
            case 1:
                System.out.println("|-----------------------------------------------|");
                System.out.println("| . 1 Register Student                          |");
                System.out.println("|-----------------------------------------------|");
                break;

            case 2:
                System.out.println("|-----------------------------------------------|");
                System.out.println("| . 2 Find Student                              |");
                System.out.println("|-----------------------------------------------|");
                break;

            case 3:
                System.out.println("|-----------------------------------------------|");
                System.out.println("| . 3 Enroll Student to Course                  |");
                System.out.println("|-----------------------------------------------|");
                break;

            case 4:
                System.out.println("|-----------------------------------------------|");
                System.out.println("| . 4 Grade/Regrade Student                     |");
                System.out.println("|-----------------------------------------------|");
                break;

            case 5:
                System.out.println("|-----------------------------------------------|");
                System.out.println("| . 5 Show Students Summary                     |");
                System.out.println("|-----------------------------------------------|");
                break;

            case 6:
                System.out.println("|-----------------------------------------------|");
                System.out.println("| . 6 Show Courses Summary                      |");
                System.out.println("|-----------------------------------------------|");
                break;

            case 7:
                System.out.println("|-----------------------------------------------|");
                System.out.println("| . 7 Show Passed Courses (by Student)          |");
                System.out.println("|-----------------------------------------------|");
                break;
        }
    }
    
}
