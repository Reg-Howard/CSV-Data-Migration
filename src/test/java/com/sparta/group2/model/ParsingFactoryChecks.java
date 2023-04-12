package com.sparta.group2.model;

import com.sparta.group2.model.factory.ParsingFactory;
import java.time.LocalDate;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ParsingFactoryChecks {
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
}
