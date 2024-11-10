package org.example.share;

import java.time.LocalDate;

public class Validate {
    public static boolean isValidateName(String name) {
        if (name == null || name.isBlank() || name.length() > Constant.MAX_NAME_LENGTH){
            System.out.println("Name cannot be empty and should contain fewer than 100 characters.");
            return false;
        }
        return true;
    }

    public static boolean isValidateOfBirth(LocalDate localDate){
        if (localDate == null || localDate.getYear() < Constant.MIN_BIRTHDAY_YEAR || localDate.getYear() > Constant.MAX_BIRTHDAY_YEAR){
            System.out.println("Birthdate should be between " + Constant.MIN_BIRTHDAY_YEAR + " and " + Constant.MAX_BIRTHDAY_YEAR);
            return false;
        }
        return true;
    }
    public static boolean isValidateAddress(String address){
        if (address.length() > Constant.MAX_ADDRESS_LENGTH || address.isBlank()){
            System.out.println("Address cannot be empty and must be less than 300 characters.");
            return false;
        }
        return true;
    }
    public static boolean isValidateHeight(Double height){
        if (height == null || height < Constant.MIN_HEIGHT_CM|| height > Constant.MAX_HEIGHT_CM){
            System.out.println("Height should be no less than 50.0cm and no more than 300.0cm.");
            return false;
        }
        return true;
    }
    public static boolean isValidateWeight(Double weight){
        if (weight == null || weight < Constant.MIN_WEIGHT_KG || weight > Constant.MAX_WEIGHT_KG){
            System.out.println("Weight should be no less than 5.0kg and no more than 1000.0kg.");
            return false;
        }
        return true;
    }
    public static boolean isValidateStudentCode(String studentCode){
        if (studentCode == null || studentCode.isBlank() || studentCode.length() != Constant.MAX_STUDENT_ID_LENGTH){
            System.out.println("Student code should be 10 characters long and cannot be empty.");
            return false;
        }
        return true;
    }
    public static boolean isValidateSchoolName(String schoolName){
        if (schoolName == null || schoolName.isBlank() || schoolName.length() > Constant.MAX_SCHOOL_NAME_LENGTH){
            System.out.println("SchoolName must not be null or blank and must contain fewer than 200 characters.");
            return false;
        }
        return true;
    }
    public static boolean isValidateStartingYear(Integer startingYear){
        if (startingYear == null || startingYear < Constant.MIN_YEAR || startingYear > Constant.MAX_YEAR){
            System.out.println("Starting year must be between " + Constant.MIN_YEAR + " and " + Constant.MAX_YEAR);
            return false;
        }
        return true;
    }
    public static boolean isValidateGPA(Double GPA){
        if (GPA == null || GPA < Constant.MIN_GPA || GPA > Constant.MAX_GPA){
            System.out.println("GPA must be between " + Constant.MIN_GPA + " and " + Constant.MAX_GPA);
            return false;
        }
        return true;
    }
    public static boolean isValidatePerson(String name, LocalDate dateOfBirth, String address, Double height, Double weight){
        if (isValidateName(name))
            if (isValidateOfBirth(dateOfBirth))
                if (isValidateAddress(address))
                    if (isValidateHeight(height))
                        return isValidateWeight(weight);
        return false;
    }
    public static boolean isValidateStudent(String studentCode, String schoolName, Integer startingYear, Double GPA){
        if (isValidateStudentCode(studentCode))
            if (isValidateSchoolName(schoolName))
                if (isValidateStartingYear(startingYear))
                    return isValidateGPA(GPA);
        return false;
    }
}
