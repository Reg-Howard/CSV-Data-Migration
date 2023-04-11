package com.sparta.group2.model;

import com.sparta.group2.model.factory.EmployeeFactory;
import com.sparta.group2.model.factory.FileReader;
import com.sparta.group2.model.factory.ParsingFactory;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.BDDAssertions.then;

public class FileReaderChecks {

    EmployeeDTO mockEmployeeDTO1;
    EmployeeDTO mockEmployeeDTO2;
    EmployeeDTO dummyEmployeeDTO;
    String[] splitDummyEmployeeDTO;
    List<String> employeeRawData = new ArrayList<>();
    String[] stringList;

    @BeforeEach
    void setup(){
        mockEmployeeDTO1 = mock(EmployeeDTO.class);
        mockEmployeeDTO2 = mock(EmployeeDTO.class);
        stringList = new String[]{"198429", "Mrs.", "Serafina", "I", "Bumgarner", "F",
                "serafina.bumgarner@exxonmobil.com", "21/09/1982", "01/02/2008", "69294"};
        EmployeeDTO dummyEmployeeDTO = new EmployeeDTO(198429, "Mrs.", "Serafina", "I",
                "Bumgarner","F","serafina.bumgarner@exxonmobil.com", LocalDate.of(1982,9,21),
                LocalDate.of(2008,2,1), 69294);
    }
    @Test
    @DisplayName("Check input stream is passing data")
    void checkInputStreamIsPassingData() {
        //Arrange
        // List<String> items = new ArrayList<>(); - Being carried out globally
        //Act
        EmployeeDTO temp = EmployeeFactory.createEmployee("133641,Mr.,Chas,F,Hurdle,M,chas.hurdle@gmail.com,20/04/1995,28/05/2016,45102");
        //Assert
        assertEquals("198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294", employeeRawData.get(0));
    }
    @Test
    @DisplayName("Check input stream is passing all the data")
    void checkInputStreamIsPassingAllTheData() {
        //Arrange
        // List<String> items = new ArrayList<>(); - Being carried out globally
        //Act
        EmployeeDTO temp = EmployeeFactory.createEmployee("133641,Mr.,Chas,F,Hurdle,M,chas.hurdle@gmail.com,20/04/1995,28/05/2016,45102");
        //Assert
        assertEquals("133641,Mr.,Chas,F,Hurdle,M,chas.hurdle@gmail.com,20/04/1995,28/05/2016,45102", employeeRawData.get(9999));
    }
    @Test
    @DisplayName("Check split method has returned the expected number of strings")
    void checkSplitMethodHasReturnedTheExpectedNumberOfStrings() {
        //Arrange
        EmployeeDTO temp = EmployeeFactory.createEmployee("198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");
        //Act
        splitDummyEmployeeDTO = temp.toString().split(",");
        //Assert
        if (stringList.length != splitDummyEmployeeDTO.length){
            Assertions.fail();
        } else {
            for(int i = 0; i < 10; i++){
                assertEquals(stringList[i], splitDummyEmployeeDTO[i]);
            }
        }
    }
    @Test
    @DisplayName("Check that number strings are being parsed to integers")
    void checkThatNumberStringsAreBeingParsedToIntegers() {
        //Arrange
        String numStr = "198429";
        int num = 0;
        //Act
        num = ParsingFactory.toInt(numStr);
        //Assert
        assertEquals(198429, num);
    }
    @Test
    @DisplayName("Check that number strings are being parsed to integers with an empty string")
    void checkThatNumberStringsAreBeingParsedToIntegersWithAnEmptyString() {
        //Arrange
        String numStr = "";
        int num = 0;
        //Act
        num = ParsingFactory.toInt(numStr);
        //Assert
        assertEquals(0, num);
    }
    @Test
    @DisplayName("Check that date strings are being parsed to dates with a four digit year")
    void checkThatDateStringsAreBeingParsedToDatesWithFourDigitYear() {
        //Arrange
        String dateStr = "21/09/1982";
        LocalDate date;
        //Act
        date = ParsingFactory.toDate(dateStr);
        //Assert
        assertEquals("1982-09-21",date.toString());
    }
    @Test
    @DisplayName("Check that date strings are being parsed to dates with a two digit year less than twenty six")
    void checkThatDateStringsAreBeingParsedToDatesWithATwoDigitYearLessThanTwentySix() {
        //Arrange
        String dateStr = "21/09/04";
        LocalDate date;
        //Act
        date = ParsingFactory.toDate(dateStr);
        //Assert
        assertEquals("2004-09-21",date.toString());
    }
    @Test
    @DisplayName("Check that date strings are being parsed to dates with a two digit year greater than twenty five")
    void checkThatDateStringsAreBeingParsedToDatesWithATwoDigitYearGreaterThanTwentyFive() {
        //Arrange
        String dateStr = "21/09/26";
        LocalDate date;
        //Act
        date = ParsingFactory.toDate(dateStr);
        //Assert
        assertEquals("1926-09-21",date.toString());
    }
    @Test
    @DisplayName("Check that date strings are being parsed to dates with a null value")
    void checkThatDateStringsAreBeingParsedToDatesWithANullValue() {
        //Arrange
        String dateStr = null;
        LocalDate date;
        //Act
        date = ParsingFactory.toDate(dateStr);
        //Assert
        assertEquals(null,date);
    }
    @Test
    @DisplayName("Check that date strings are being parsed to dates with an empty string")
    void checkThatDateStringsAreBeingParsedToDatesWithAnEmptyString() {
        //Arrange
        String dateStr = "";
        LocalDate date;
        //Act
        date = ParsingFactory.toDate(dateStr);
        //Assert
        assertEquals(null,date);
    }
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
        assertEquals(198429,dummyEmployeeDTO2.getId());
        assertEquals("Mrs.",dummyEmployeeDTO2.getPrefix());
        assertEquals("Serafina",dummyEmployeeDTO2.getFirstName());
        assertEquals("I",dummyEmployeeDTO2.getMiddleInitial());
        assertEquals("Bumgarner",dummyEmployeeDTO2.getLastName());
        assertEquals("F",dummyEmployeeDTO2.getGender());
        assertEquals("serafina.bumgarner@exxonmobil.com",dummyEmployeeDTO2.getMail());
        assertEquals(LocalDate.of(1982,9,21),dummyEmployeeDTO2.getDob());
        assertEquals(LocalDate.of(2008,2,1),dummyEmployeeDTO2.getStartDate());
        assertEquals(69294,dummyEmployeeDTO2.getSalary());
    }
}