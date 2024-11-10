package org.example.MainViewer;

import org.example.controller.StudentController;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainView {
    private static void printMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1. Add new student");
        System.out.println("2. Search student by ID");
        System.out.println("3. Search student by Student Code");
        System.out.println("4. Update student by ID");
        System.out.println("5. Delete student by ID");
        System.out.println("6. Display student list");
        System.out.println("7. Display grade level percent");
        System.out.println("8. Display GPA percent");
        System.out.println("9. Get student by grade level");
        System.out.println("10. Exit and save student list to file");
        System.out.print("Enter your select: ");
    }

    public static int getMenu() {
        Scanner scanner = new Scanner(System.in);
        printMenu();
        int choice = 0;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please choose menu again.");
            return getMenu();
        }
        return choice;
    }

    private static void printDataStructureMenu() {
        System.out.println("Select the data structure you want to use:");
        System.out.println("1. Fixed-size Array");
        System.out.println("2. ArrayList");
        System.out.println("3. Exit");
        System.out.print("Enter your select: ");
    }

    private static int getDataStructureChoice() {
        Scanner scanner = new Scanner(System.in);
        printDataStructureMenu();
        int choice = 0;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please choose data structure again.");
            return getDataStructureChoice();
        }
        if (choice < 1 || choice > 3) {
            System.out.println("Invalid choice. Please enter 1 for Fixed-size Array, 2 for ArrayList or 3 for Exit.");
            return getDataStructureChoice();
        }
        return choice;
    }

    public void run() {
        try {
            StudentController studentController = new StudentController();
            switch (getDataStructureChoice()) {
                case 1:
                    studentController = new StudentController(1);
                    break;
                case 2:
                    studentController = new StudentController(2);
                    break;
                case 3:
                    System.out.println("Exit");
                    return;
            }
            int choice = 0;
            while (true) {
                choice = getMenu();
                switch (choice) {
                    case 1:
                        studentController.addStudent();
                        break;
                    case 2:
                        studentController.searchById();
                        break;
                    case 3:
                        studentController.searchByStudentCode();
                        break;
                    case 4:
                        studentController.updateById();
                        break;
                    case 5:
                        studentController.deleteById();
                        break;
                    case 6:
                        studentController.getAllStudents();
                        break;
                    case 7:
                        studentController.viewGradeLevelPercent();
                        break;
                    case 8:
                        studentController.viewPercentGPA();
                        break;
                    case 9:
                        studentController.viewStudentByGradeLevel();
                        break;
                    case 10:
                        studentController.saveToFile();
                        System.out.println("Student list saved to file successfully!");
                        return;
                }
            }
        } catch (IllegalArgumentException exception) {
            System.out.println("Error:c " + exception.getMessage());
        } catch (IOException exception) {
            System.out.println("Not found: " + exception.getMessage());
        }
    }
}
