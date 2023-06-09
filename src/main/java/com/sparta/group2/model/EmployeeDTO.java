package com.sparta.group2.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class EmployeeDTO {

    private int id;
    private String prefix;
    private String firstName;
    private String middleInitial;
    private String lastName;
    private String gender;
    private String mail;
    private LocalDate dob;
    private LocalDate startDate;
    private double salary;

    public EmployeeDTO(int id, String prefix, String firstName, String middleInitial, String lastName, String gender, String mail, LocalDate dob, LocalDate startDate, double salary) {
        this.id = id;
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.mail = mail;
        this.dob = dob;
        this.startDate = startDate;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(String middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String eMail) {
        this.mail = eMail;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return
                "ID: " + id + " " +
                "Prefix: " + prefix + " " +
                "First Name: " + firstName + "  " +
                "Middle Initial: " + middleInitial + "  " +
                "Last Name: " + lastName + "    " +
                "Gender: " + gender + " " +
                "Email: " + mail + "    " +
                "Date of Birth: " + dob.format(formatter) + "   " +
                "Start Date: " + startDate.format(formatter) + "    " +
                "Salary: " + (int)salary ;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        EmployeeDTO that = (EmployeeDTO) o;

        if (!Objects.equals(firstName, that.firstName)) {
            return false;
        }
        if (!Objects.equals(middleInitial, that.middleInitial)) {
            return false;
        }
        return Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return id;
    }
}