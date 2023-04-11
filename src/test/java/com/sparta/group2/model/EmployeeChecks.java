package com.sparta.group2.model;

import com.sparta.group2.model.factory.EmployeeFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeChecks {

    //For this test to be proven the hashcodes tested by overrided .equals method must be the same, i.e they are different objects but the same values
    //Hashcode and equals method override in EmployeeDTO's
    @Nested
    @DisplayName("Employee validation checks:")
    public class EmployeeValidationChecks {
        @Test
        void testEmployeeObjectEquality() {
            EmployeeDTO
                    emp1 =
                    EmployeeFactory.createEmployee(
                            "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");
            EmployeeDTO
                    emp2 =
                    EmployeeFactory.createEmployee(
                            "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");
            Assertions.assertTrue(emp1.equals(emp2));
        }

        @Test
        void testEmployeeSetMethods() {
            EmployeeDTO
                    emp4 =
                    EmployeeFactory.createEmployee(
                            "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");
            EmployeeDTO emp5 = EmployeeFactory.createEmployee("1,Mr.,James,R,Reed,M,james.reed@spartaglobal.com,23/12/1996,1/1/2011,1");
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyyy");
            emp4.setId(1);
            emp4.setPrefix("Mr.");
            emp4.setFirstName("James");
            emp4.setMiddleInitial("R");
            emp4.setLastName("Reed");
            emp4.setGender("M");
            emp4.setMail("james.reed@spartaglobal.com");
            emp4.setDob(LocalDate.parse("23/12/1996", formatter));
            emp4.setStartDate(LocalDate.parse("1/1/2011", formatter));
            emp4.setSalary(1);

            Assertions.assertTrue(emp5.toString().equals(emp4.toString()));

        }
    }
}
