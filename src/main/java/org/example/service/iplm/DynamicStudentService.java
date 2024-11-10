package org.example.service.iplm;

import org.example.model.Student;
import org.example.service.StudentServiceInterface;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DynamicStudentService implements StudentServiceInterface {
    List<Student> students = new ArrayList<>();

    @Override
    public void addStudent(Student student) {
        try {
            students.add(student);
            System.out.println("Student add successful");
            System.out.println(student);
        } catch (IllegalArgumentException error){
            System.out.println("Error: "+error.getMessage());
        }

    }

    @Override
    public Student searchById(int id) {
        for (Student student : students) {
            if (student.getId() == id)
                return student;
        }
        return null;
    }

    @Override
    public Student searchByStudentCode(String studentCode) {
        for (Student student: students){
            if (student.getStudentCode().equals(studentCode))
                return student;
        }
        return null;
    }

    @Override
    public void updateById(int id, Student newStudent) {
        Student existsStudent = searchById(id);
        if (existsStudent == null) {
            System.out.println("No student found with ID: " + id);
            return;
        }
        for (Student student : students) {
            if (student.getId() == id) {
                student.setName(newStudent.getName());
                student.setDateOfBirth(newStudent.getDateOfBirth());
                student.setAddress(newStudent.getAddress());
                student.setHeight(newStudent.getHeight());
                student.setWeight(newStudent.getWeight());
                student.setStudentCode(newStudent.getStudentCode());
                student.setSchoolName(newStudent.getSchoolName());
                student.setStartyear(newStudent.getStartyear());
                student.setGPA(newStudent.getGPA());
                System.out.println("Student updated successfully");
                System.out.println(student);
                return;
            }
        }

    }

    @Override
    public void deleteById(int id) {
        Student student = searchById(id);
        if (student == null) {
            System.out.println("Student not found with id " + id);
            return;
        }
        for (int i = 0; i < students.size();i++){
            if (students.contains(student)){
                students.remove(student);
                System.out.println("Student deleted successfully");
                return;
            }
        }
    }

    @Override
    public List<Student> getAllStudents() {
        if (!students.isEmpty())
            return students;
        return null;
    }

    @Override
    public void viewGradeLevelPercent() {
    }

    @Override
    public void viewPercentGPA() {

    }

    @Override
    public List<Student> getStudentByGradeLevel(String inputGradeLevel) {
        return null;
    }

    @Override
    public void SaveToFile(String filename) throws IOException {

    }
}
