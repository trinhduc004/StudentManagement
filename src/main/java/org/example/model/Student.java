package org.example.model;

import org.example.share.AcademicPerformanceEnum;
import org.example.share.Validate;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Student extends Person implements Serializable {
    //thuoc tinh
    private String studentCode;
    private String SchoolName;
    private Integer Startyear;
    private Double GPA;
    private AcademicPerformanceEnum academicPerformanceEnum;
    private static final Set<String> ExistingStudentCode = new HashSet<>();

    //constructer
    public Student(String name, LocalDate dateOfBirth, String address, Double height, Double weight,
                   String studentCode, String schoolName, Integer startyear, Double GPA) {
        super(name, dateOfBirth, address, height, weight);
        if (!Validate.isValidateStudent(studentCode, schoolName, startyear, GPA))
            return;
        this.studentCode = studentCode;
        this.SchoolName = schoolName;
        this.Startyear = startyear;
        this.GPA = GPA;
        this.academicPerformanceEnum = setAcademicPerformanceEnum();
    }
    //get/set

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public Integer getStartyear() {
        return Startyear;
    }

    public void setStartyear(Integer startyear) {
        Startyear = startyear;
    }

    public Double getGPA() {
        return GPA;
    }

    public void setGPA(Double GPA) {
        this.GPA = GPA;
    }

    private AcademicPerformanceEnum setAcademicPerformanceEnum(){
        if (GPA == null)
            return null;
        if (GPA < 3)
            return AcademicPerformanceEnum.KEM;
        if (GPA < 5)
            return AcademicPerformanceEnum.YEU;
        if (GPA < 6.5)
            return AcademicPerformanceEnum.TRUNG_BINH;
        if (GPA < 7.5)
            return AcademicPerformanceEnum.KHA;
        if (GPA < 9)
            return AcademicPerformanceEnum.GIOI;
        return AcademicPerformanceEnum.XUAT_SAC;
    }

    public AcademicPerformanceEnum getAcademicPerformanceEnum() {
        return academicPerformanceEnum;
    }
    //toString

    @Override
    public String toString() {
        /*return super.toString()+
                "studentCode='" + studentCode + '\'' +
                ", SchoolName='" + SchoolName + '\'' +
                ", Startyear=" + Startyear +
                ", GPA=" + GPA +
                ",Academic Performance="+ academicPerformanceEnum;*/
        return super.toString()+
                " ,studentCode: "+studentCode+" ,SchoolName: "+SchoolName+" ,Startyear: "+Startyear+" ,GPA: "+GPA+" ,Academic Performance: "+academicPerformanceEnum;
    }
}
