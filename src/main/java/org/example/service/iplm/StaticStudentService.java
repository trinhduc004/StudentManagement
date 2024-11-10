package org.example.service.iplm;

import org.example.service.StudentServiceInterface;
import org.example.model.Student;
import org.example.share.AcademicPerformanceEnum;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class StaticStudentService implements StudentServiceInterface {
    private static final int MAX_STUDENTS = 100;
    Student[] students = new Student[MAX_STUDENTS];
    private static int Count = 0;
    @Override
    public void addStudent(Student student) {
        students[Count++] = student;
        System.out.println("Student added successfully");
        System.out.println(student);
    }

    @Override
    public Student searchById(int id) {
        for (int i = 0; i < Count; i++){
            if (students[i].getId() == id)
                return students[i];
        }
        return null;
    }

    @Override
    public Student searchByStudentCode(String studentCode) {
        for (int i = 0; i < Count; i++){
            if (students[i].getStudentCode().equals(studentCode))
                return students[i];
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
        for (int i = 0; i < Count; i++){
            if (students[i].getId() == id){
                students[i].setName(newStudent.getName());
                students[i].setDateOfBirth(newStudent.getDateOfBirth());
                students[i].setAddress(newStudent.getAddress());
                students[i].setHeight(newStudent.getHeight());
                students[i].setWeight(newStudent.getWeight());
                students[i].setStudentCode(newStudent.getStudentCode());
                students[i].setSchoolName(newStudent.getSchoolName());
                students[i].setStartyear(newStudent.getStartyear());
                students[i].setGPA(newStudent.getGPA());
                System.out.println("Student updated successfully");
                System.out.println(searchById(id));
                return;
            }
        }
    }

    @Override
    public void deleteById(int id) {
        Student student = searchById(id);
        if (student == null){
            System.out.println("No student found with ID: " + id);
            return;
        }
        for (int i = 0; i < Count;i++){
            if (students[i].getId() == student.getId()){
                while (i < Count - 1){
                    students[i] = students[i + 1];
                    i++;
                }
                students[i] = null;
                Count--;
                System.out.println("Student deleted successfully");
                return;
            }
        }
    }

    @Override
    public List<Student> getAllStudents() {
        if (Count > 0){
            return new ArrayList<>(Arrays.asList(students).subList(0, Count));
        } else
            return null;
    }

    @Override
    public void viewGradeLevelPercent() {
        Map<AcademicPerformanceEnum, Integer> countByGradeLevel = new LinkedHashMap<>();
        for (AcademicPerformanceEnum grade : AcademicPerformanceEnum.values()){
            countByGradeLevel.put(grade, 0);
        }
        for (int i = 0; i < Count; i++){
            AcademicPerformanceEnum currentGrade = students[i].getAcademicPerformanceEnum();
            int currentValue = countByGradeLevel.get(currentGrade);
            if (countByGradeLevel.containsKey(currentGrade))
                countByGradeLevel.replace(currentGrade,currentValue+1);
        }
        LinkedHashMap<AcademicPerformanceEnum, Double> percentageOfGradeLevel = new LinkedHashMap<>();
        for (AcademicPerformanceEnum gradeLevel: AcademicPerformanceEnum.values()){
            long amount = countByGradeLevel.getOrDefault(gradeLevel,0);
            double percent = (amount / (double) Count)* 100;
            percentageOfGradeLevel.put(gradeLevel, percent);
        }
        for (Map.Entry<AcademicPerformanceEnum, Double> entry : sortMap(percentageOfGradeLevel).entrySet()){
            System.out.printf("%s: %.2f%%%n",entry.getKey(),entry.getValue());
        }
    }
    private LinkedHashMap<AcademicPerformanceEnum, Double> sortMap(LinkedHashMap<AcademicPerformanceEnum,Double > map){
        Set<Map.Entry<AcademicPerformanceEnum,Double>> mapping = map.entrySet();
        Comparator<Map.Entry<AcademicPerformanceEnum,Double>> comparator =
                (Map.Entry<AcademicPerformanceEnum,Double> o1, Map.Entry<AcademicPerformanceEnum, Double> o2) ->{
            Double v1 = o1.getValue();
            Double v2 = o2.getValue();
            return v2.compareTo(v1);
                };
        List<Map.Entry<AcademicPerformanceEnum,Double>> listEntries = new ArrayList<>(mapping);
        listEntries.sort(comparator);
        LinkedHashMap<AcademicPerformanceEnum, Double> sortedMap = new LinkedHashMap<>();
        listEntries.forEach(entry -> sortedMap.put(entry.getKey(),entry.getValue()));
        return sortedMap;
    }
    @Override
    public void viewPercentGPA() {
        Map<Double, Integer> countByGPA = new LinkedHashMap<>();
        for (int i = 0 ; i < Count; i++){
            Double currentGPA = students[i].getGPA();
            int currentValue = 0;
            if (countByGPA.containsKey(currentGPA)){
                currentValue = countByGPA.get(currentGPA);
            }
            countByGPA.put(currentGPA, currentValue + 1);
        }
        for (Map.Entry<Double, Integer> entry : countByGPA.entrySet()){
            double percent = (entry.getValue() / (double) Count)*100;
            System.out.printf("GPA %.2f: %.2f%%%n", entry.getKey(), percent);
        }
    }
    private AcademicPerformanceEnum getAcademicPerformanceEnum(String inputGradelevel){
        for (AcademicPerformanceEnum gradeLevel : AcademicPerformanceEnum.values()){
            if (gradeLevel.getvalue().equals(inputGradelevel)){
                return gradeLevel;
            }
        }
        return null;
    }

    @Override
    public List<Student> getStudentByGradeLevel(String inputGradeLevel) {
        AcademicPerformanceEnum gradeLevel = getAcademicPerformanceEnum(inputGradeLevel);
        List<Student> student = new ArrayList<>();
        if (gradeLevel !=null){
            for (int i = 0; i < Count; i++){
                if (students[i].getAcademicPerformanceEnum().equals(gradeLevel)){
                    student.add(students[i]);
                }
            }
        }
        return student;
    }

    @Override
    public void SaveToFile(String filename) throws IOException {
        PrintWriter writer = new PrintWriter(filename, StandardCharsets.UTF_8);
        for (int i = 0; i < Count; i++){
            writer.println(students[i]);
        }
        writer.flush();
        writer.close();
    }
}
