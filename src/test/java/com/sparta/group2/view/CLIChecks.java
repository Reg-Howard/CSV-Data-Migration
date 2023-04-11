package com.sparta.group2.view;

import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.factory.EmployeeFactory;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class CLIChecks {
    @Nested
    @DisplayName("Command Line Interface validation checks:")
    public class CLIValidationChecks {
        @Test
        @DisplayName("Test empty input returns null")
        void testCreateEmployeeWithEmptyInput() {
            String input = "";
            EmployeeDTO employee = EmployeeFactory.createEmployee(input);
            assertNull(employee);
        }

    }
}
