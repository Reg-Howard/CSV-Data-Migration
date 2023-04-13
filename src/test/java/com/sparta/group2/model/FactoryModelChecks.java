package com.sparta.group2.model;

import com.sparta.group2.model.factory.EmployeeFactory;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class FactoryModelChecks {

    @Nested
    @DisplayName("Factory raw data input checks:")
    public class FactoryRawDataInputChecks {
        @Test//create check for storing the data in objects
        @DisplayName("Check that store method is creating employee objects for the data to be entered into")
        void checkThatStoreMethodIsCreatingEmployeeObjectsForTheDataToBeEnteredInto() {
            //Arrange
            EmployeeDTO dummyEmployeeDTO2;
            //Act
            dummyEmployeeDTO2 = EmployeeFactory.createEmployee(null);
            //Assert
            assertEquals(null, dummyEmployeeDTO2);
        }

        @Test
        @DisplayName("Check that the employee objects created by the store method are not returned empty")
        void checkThatTheEmployeeObjectsCreatedByTheStoreMethodAreNotReturnedEmpty() {
            //Arrange
            EmployeeDTO dummyEmployeeDTO2;
            //Act
            dummyEmployeeDTO2 = EmployeeFactory.createEmployee("");
            //Assert
            assertEquals(null, dummyEmployeeDTO2);
        }

        @Test
        @DisplayName("Check that the employee object will not be created with anything other than 10 properties")
        void checkThatTheEmployeeObjectWillNotBeCreatedWithAnythingOtherThan10Properties() {
            //Arrange
            EmployeeDTO dummyEmployeeDTO2;
            //Act
            dummyEmployeeDTO2 = EmployeeFactory.createEmployee("198429");
            //Assert
            assertEquals(null, dummyEmployeeDTO2);
        }

        @Test
        @DisplayName("Check that all data is being correctly cast and stored together in an employee object")
        void checkThatAllDataIsBeingCorrectlyCastAndStoredTogetherInAnEmployeeObject() {
            //Arrange
            EmployeeDTO dummyEmployeeDTO2;
            //Act
            dummyEmployeeDTO2 = EmployeeFactory.createEmployee("198429,Mrs.,Serafina,I,Bumgarner,F," +
                    "serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");
            //Assert
            assertEquals(198429, dummyEmployeeDTO2.getId());
            assertEquals("Mrs.", dummyEmployeeDTO2.getPrefix());
            assertEquals("Serafina", dummyEmployeeDTO2.getFirstName());
            assertEquals("I", dummyEmployeeDTO2.getMiddleInitial());
            assertEquals("Bumgarner", dummyEmployeeDTO2.getLastName());
            assertEquals("F", dummyEmployeeDTO2.getGender());
            assertEquals("serafina.bumgarner@exxonmobil.com", dummyEmployeeDTO2.getMail());
            assertEquals(LocalDate.of(1982, 9, 21), dummyEmployeeDTO2.getDob());
            assertEquals(LocalDate.of(2008, 2, 1), dummyEmployeeDTO2.getStartDate());
            assertEquals(69294, dummyEmployeeDTO2.getSalary());
        }
    }
}
