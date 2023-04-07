package com.sparta.group2.model.factory;

import com.sparta.group2.model.EmployeeDTO;

import java.time.LocalDate;

public class EmployeeFactory {

    public static EmployeeDTO createEmployee(String input){

        if(input == null || input.equals("")){
            return null;
        }

        String[] splitInput = input.split(",");
        if(splitInput.length != 10){
            return null;
        }

        int id = ParsingFactory.toInt(splitInput[0]);
        String prefix = splitInput[1];
        String firstName = splitInput[2];
        String middleInitial = splitInput[3];
        String lastName = splitInput[4];
        String gender = splitInput[5];
        String mail = splitInput[6];
        LocalDate dob = ParsingFactory.toDate(splitInput[7]);
        LocalDate startDate = ParsingFactory.toDate(splitInput[8]);
        double salary = ParsingFactory.toInt(splitInput[9]);

        return new EmployeeDTO(id,prefix,firstName,middleInitial,lastName,gender,mail,dob,startDate,salary);
    }
}