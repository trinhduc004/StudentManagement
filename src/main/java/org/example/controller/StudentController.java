package org.example.controller;

import org.example.model.Student;
import org.example.service.StudentServiceInterface;
import org.example.service.iplm.DynamicStudentService;
import org.example.service.iplm.StaticStudentService;
import org.example.share.Validate;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class StudentController {
    private final Scanner scanner = new Scanner(System.in);
    private StudentServiceInterface studentService;

    public StudentController(){
    }
    public StudentController(int select){
        if (select == 1)
            studentService = new StaticStudentService();
        if (select == 2)
            studentService = new DynamicStudentService();
    }
    public void addStudent(){
        System.out.println("->Add new Student");
        studentService.addStudent(inputStudentFromKeyboard());
    }
    public void searchById(){
        System.out.println("->Search Student By ID");
        Integer id = null;
        while (id == null){
            try {
                System.out.print("Enter ID: ");
                id = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid format. Please try again.");
            }
            scanner.nextLine();
        }
        Student student = studentService.searchById(id);
        if (student != null){
            System.out.println("Student found: " + student);
        }else
            System.out.println("No found stident with ID: "+ id);
    }
    public void searchByStudentCode(){
        System.out.println("->Search Student By Student Code");
        System.out.print("Enter Student Code: ");
        String studentCode = scanner.nextLine();
        Student student = studentService.searchByStudentCode(studentCode);
        if (student!= null)
            System.out.println("Student found: " + student);
        else
            System.out.println("No found student with Student Code: " + studentCode);
    }
    public void updateById(){
        System.out.println("->Update Student");
        Integer id = null;
        while (id == null){
            try {
                System.out.print("Enter ID: ");
                id = scanner.nextInt();
            }catch (InputMismatchException e){
                System.out.println("Invalid format. Please try again.");
            }
            scanner.nextLine();
        }
        if (studentService.searchById(id) == null){
            System.out.println("No student found to update with ID: " + id);
            return;
        }
        Student newStudent = inputUpdateStudent(id);
        studentService.updateById(id, newStudent);
    }
    public void deleteById(){
        System.out.println("->Delete Student By ID");
        Integer id = null;
        while (id == null){
            try {
                System.out.println("Enter id: ");
                id = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Invalid format, please enter again.");
            }
            scanner.nextLine();
        }
        studentService.deleteById(id);
    }
    public void getAllStudents(){
        System.out.println("->Get list students");
        List<Student> students = studentService.getAllStudents();
        if (students != null){
            students.forEach(System.out::println);
        }else
            System.out.println("Student list is empty");
    }
    public void viewGradeLevelPercent(){
        System.out.println("->View Grade Level Percent");
        studentService.viewGradeLevelPercent();
    }
    public void viewPercentGPA(){
        System.out.println("->View Percent GPA");
        studentService.viewPercentGPA();
    }
    public void viewStudentByGradeLevel(){
        System.out.println("->View Student By Grade Level");
        System.out.print("Enter Grade Level: ");
        String inputGradeLevel = scanner.nextLine();
        inputGradeLevel = inputGradeLevel.toUpperCase(Locale.ROOT);
        List<Student> students = studentService.getStudentByGradeLevel(inputGradeLevel);
        if (!students.isEmpty()){
            System.out.println("Student found: ");
            students.forEach(System.out::println);
        } else
            System.out.println("No found student with this level");
    }
    public void saveToFile() throws IOException {
        System.out.println("->Save To File");
        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();
        studentService.SaveToFile(filename);
    }
    private String inputName(){
        String name;
        do {
            System.out.print("Enter name: ");
            name = scanner.nextLine();
        } while (!Validate.isValidateName(name));
        return name;
    }
    private LocalDate inputBirthOfDate(){
        LocalDate birthOfDate = null;
        do {
            System.out.print("Enter birth of date (YYYY-MM-DD): ");
            String inputDate = scanner.nextLine();
            try {
                birthOfDate = LocalDate.parse(inputDate);
            } catch (DateTimeParseException e){
                System.out.println("Invalid date format. Please try again.");
            }
        } while (birthOfDate == null);
        return birthOfDate;
    }
    private String inputAddress(){
        String address;
        do {
            System.out.println("Enter address: ");
            address = scanner.nextLine();
        }while (!Validate.isValidateAddress(address));
            return address;
    }
    private Double inputHeight(){
        Double height = null;
        do {
            System.out.print("Enter height (cm): ");
            try {
                height = scanner.nextDouble();
            } catch (InputMismatchException e){
                System.out.println("Invalid format. Please try again.");
            }
            scanner.nextLine();
        } while (!Validate.isValidateHeight(height));
        return height;
    }
    private Double inputWeight(){
        Double weight = null;
        do {
            System.out.print("Enter weight (kg): ");
            try {
                weight = scanner.nextDouble();
            } catch (InputMismatchException e){
                System.out.println("Invalid format. Please try again.");
            }
            scanner.nextLine();
        } while (!Validate.isValidateWeight(weight));
        return weight;
    }
    private String inputStudentCode(){
        String studentCode;
        do {
            System.out.print("Enter student code: ");
            studentCode = scanner.nextLine();
            if (studentService.searchByStudentCode(studentCode)!= null)
                System.out.println("Student code already exists. Please try again."+ studentCode);
        } while (!Validate.isValidateStudentCode(studentCode) || studentService.searchByStudentCode(studentCode) !=null);
        return studentCode;
    }
    private String inputShoolName(){
        String schoolName;
        do {
            System.out.print("Enter school name: ");
            schoolName = scanner.nextLine();
        } while (!Validate.isValidateSchoolName(schoolName));
        return schoolName;
    }
    private Integer inputStartingYear(){
        Integer startingYear = null;
        do {
            System.out.print("Enter starting year: ");
            try {
                startingYear = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Invalid format. Please try again.");
            }
            scanner.nextLine();
        } while (!Validate.isValidateStartingYear(startingYear));
        return startingYear;
    }
    private Integer inputStartYear(){
        Integer yearOfStarting = null;
        do {
            System.out.println("Enter year of starting: ");
            try {
                yearOfStarting = scanner.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Invalid format. Please try again.");
            }
            scanner.nextLine();
        }while (!Validate.isValidateStartingYear(yearOfStarting));
        return yearOfStarting;
    }
    private Double inputGPA(){
        Double GPA = null;
        do {
            System.out.print("Enter GPA: ");
            try {
                GPA = scanner.nextDouble();
            } catch (InputMismatchException e){
                System.out.println("Invalid format. Please try again.");
            }
            scanner.nextLine();
        } while (!Validate.isValidateGPA(GPA)|| GPA== null);
        return GPA;
    }
    private Student inputStudentFromKeyboard(){
        String name = inputName();
        LocalDate birthOfDate = inputBirthOfDate();
        String address = inputAddress();
        Double height = inputHeight();
        Double weight = inputWeight();
        String studentCode = inputStudentCode();
        String schoolName = inputShoolName();
        Integer yearOfStarting = inputStartingYear();
        Double GPA = inputGPA();

        return new Student(name, birthOfDate, address, height, weight, studentCode, schoolName, yearOfStarting, GPA);
    }
    private void prrintMenuUpdate(){
        System.out.println("\n-> Please choose the field you would like to update");
        System.out.println("1. Name");
        System.out.println("2. Birth of date");
        System.out.println("3. Address");
        System.out.println("4. Height");
        System.out.println("5. Weight");
        System.out.println("6. School name");
        System.out.println("7. Starting year");
        System.out.println("8. GPA(0->10)");
        System.out.println("9. Done");
        System.out.print("Enter your selection: ");
    }
    private int getMenuUpdate(){
        prrintMenuUpdate();
        int choice = 0;
        try {
            choice = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e){
            System.out.println("Invalid input. Please try again.");
            return getMenuUpdate();
        }if (choice < 1 || choice >9){
            System.out.println("Invalid choice. Please enter between 1 and 9");
            return getMenuUpdate();
        }
        return choice;
    }
    private Student inputUpdateStudent(Integer id){
        Student updateStudent = studentService.searchById(id);
        while (true){
            int select = getMenuUpdate();
            switch (select){
                case 1:
                    updateStudent.setName(inputName());
                    break;
                case 2:
                    updateStudent.setDateOfBirth(inputBirthOfDate());
                    break;
                case 3:
                    updateStudent.setAddress(inputAddress());
                    break;
                case 4:
                    updateStudent.setHeight(inputHeight());
                    break;
                case 5:
                    updateStudent.setWeight(inputWeight());
                    break;
                case 6:
                    updateStudent.setSchoolName(inputShoolName());
                    break;
                case 7:
                    updateStudent.setStartyear(inputStartingYear());
                    break;
                case 8:
                    updateStudent.setGPA(inputGPA());
                    break;
                case 9:
                    return updateStudent;
            }
        }
    }
}
