
package com.sparta.group2.model;

import com.sparta.group2.model.factory.EmployeeFactory;
import com.sparta.group2.model.factory.FileDataReader;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.*;
import static org.assertj.core.api.BDDAssertions.then;

public class FileDataReaderChecks {

    EmployeeDTO mockEmployeeDTO1;
    EmployeeDTO mockEmployeeDTO2;
    EmployeeDTO dummyEmployeeDTO;
    String[] splitDummyEmployeeDTO;
    List<String> employeeRawData = new ArrayList<>();
    String[] stringList;

    @BeforeEach
    void setup() {
        mockEmployeeDTO1 = mock(EmployeeDTO.class);
        mockEmployeeDTO2 = mock(EmployeeDTO.class);
        stringList = new String[]{"198429", "Mrs.", "Serafina", "I", "Bumgarner", "F",
            "serafina.bumgarner@exxonmobil.com", "21/09/1982", "01/02/2008", "69294"};
        EmployeeDTO dummyEmployeeDTO = new EmployeeDTO(198429, "Mrs.", "Serafina", "I",
            "Bumgarner", "F", "serafina.bumgarner@exxonmobil.com", LocalDate.of(1982, 9, 21),
            LocalDate.of(2008, 2, 1), 69294);
    }

    @Test
    @DisplayName("Check input stream is passing data")
        void checkInputStreamIsPassingData() {
        //Arrange
        // List<String> items = new ArrayList<>(); - Being carried out globally
        //Act
        // employeeRawData = List.of(FileDataReader.readFileLines("src/main/resources/EmployeeRecords.csv"));
        //Assert
        //assertEquals("198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294", employeeRawData.get(0));
    }

    @Test
    @DisplayName("Check input stream is passing all the data")
    void checkInputStreamIsPassingAllTheData() {
        //Arrange
        // List<String> items = new ArrayList<>(); - Being carried out globally
        //Act
        // employeeRawData = List.of(FileDataReader.readFileLines("src/main/resources/EmployeeRecords.csv"));
        //Assert
        // assertEquals("133641,Mr.,Chas,F,Hurdle,M,chas.hurdle@gmail.com,20/04/1995,28/05/2016,45102", employeeRawData.get(9999));
    }

    @Test
    @DisplayName("Check split method has returned the expected number of strings")
    void checkSplitMethodHasReturnedTheExpectedNumberOfStrings() {
        //Arrange
        EmployeeDTO
            temp =
            EmployeeFactory.createEmployee(
                "198429,Mrs.,Serafina,I,Bumgarner,F,serafina.bumgarner@exxonmobil.com,21/09/1982,01/02/2008,69294");
        //Act
        splitDummyEmployeeDTO = temp.toString().split(",");
        //Assert
        if (stringList.length != splitDummyEmployeeDTO.length) {
            Assertions.fail();
        } else {
            for (int i = 0; i < 10; i++) {
                assertEquals(stringList[i], splitDummyEmployeeDTO[i]);
            }
        }
    }
}