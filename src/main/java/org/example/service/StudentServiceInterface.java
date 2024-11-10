package org.example.service;

import org.example.model.Student;

import java.io.IOException;
import java.util.List;

public interface StudentServiceInterface {
    public void addStudent(Student student);
    public Student searchById(int id);
    public Student searchByStudentCode(String studentCode);
    public void updateById(int id, Student newStudent);
    public void deleteById(int id);
    public List<Student> getAllStudents();
    public void viewGradeLevelPercent();
    public void viewPercentGPA();
    public List<Student> getStudentByGradeLevel(String inputGradeLevel);
    public void  SaveToFile(String filename) throws IOException;


}
