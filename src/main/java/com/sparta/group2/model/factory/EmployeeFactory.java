package com.sparta.group2.model.factory;

import com.sparta.group2.model.EmployeeDTO;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeFactory {

    public static EmployeeDTO createEmployee(String input){

        if(input == null || input.equals("")){
            return null;
        }
        String[] splitInput = input.split(",");
        if(splitInput.length != 10){
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
        int id = Integer.parseInt(splitInput[0]);
//        int id = ParsingFactory.toInt(splitInput[0]);         These 4 commented lines relate to the ParsingFactory.
        String prefix = splitInput[1];
        String firstName = splitInput[2];
        String middleInitial = splitInput[3];
        String lastName = splitInput[4];
        String gender = splitInput[5];
        String mail = splitInput[6];
        LocalDate dob = LocalDate.parse(splitInput[7], formatter);
        LocalDate startDate = LocalDate.parse(splitInput[8], formatter);
//        LocalDate dob = ParsingFactory.toDate(splitInput[7]);
//        LocalDate startDate = ParsingFactory.toDate(splitInput[8]);
        double salary = Double.parseDouble(splitInput[9]);
//        int salary = ParsingFactory.toInt(splitInput[9]);

        return new EmployeeDTO(id,prefix,firstName,middleInitial,lastName,gender,mail,dob,startDate,salary);
    }
}