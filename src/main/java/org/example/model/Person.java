package org.example.model;

import org.example.share.Constant;
import org.example.share.Validate;

import java.time.LocalDate;

public class Person {
    //access modifier
    private Integer id;
    private String name;
    private LocalDate dateOfBirth;
    private String address;
    private Double height;
    private Double weight;
    private static int Id = Constant.MIN_ID;

    //constructor
    public Person(String name, LocalDate dateOfBirth, String address, Double height, Double weight) {
        if (!Validate.isValidatePerson(name, dateOfBirth,address,height,weight))
            return;
        this.id = Id++;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.height = height;
        this.weight = weight;
    }

    //getters and setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (Validate.isValidateName(name))
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (Validate.isValidateOfBirth(dateOfBirth))
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (Validate.isValidateAddress(address))
        this.address = address;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        if (Validate.isValidateHeight(height))
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        if (Validate.isValidateWeight(weight))
        this.weight = weight;
    }

    //to String
    @Override
    public String toString() {
       /* return "id=" + id +
                ", name=" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", address='" + address + '\'' +
                ", height=" + height +
                ", weight=" + weight ;*/
        return "id :"+id+", name: "+name+", dateOfBirth: "+dateOfBirth+", address: "+address+", height: "+height+", weight: "+weight;
    }
}
