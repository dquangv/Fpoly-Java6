/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author votha
 */
public class Student {

    private String email;
    private String name;
    private Double marks;
    private Boolean gender;
    private String country;

    public Student() {
    }

    public Student(String email, String name, Double marks, Boolean gender, String country) {
        this.email = email;
        this.name = name;
        this.marks = marks;
        this.gender = gender;
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @JsonIgnore
    public Object[] getArray() {
        return new Object[]{
            getEmail(),
            getName(),
            getMarks(),
            getGender()?"Female":"Male",
            getCountry()
        };
    }

}
