package com.sparta.group2.model;

import com.sparta.group2.model.sql.DAO;
import org.junit.jupiter.api.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SQLModelTests {
    DAO dao;

    @BeforeEach
    void setup(){
        dao = mock(DAO.class);
    }

    @Test
    @Order(1)
    @DisplayName("1. Test finding employee by id")
    void testFindingEmployeeById() {
        EmployeeDTO employeeDTO = new EmployeeDTO(123,"Mr","Marcin","S","Jakobik","M","teest@12.com", LocalDate.of(1967,10,22),LocalDate.of(1967,10,22),1234);
        when(dao.findById(123)).thenReturn(employeeDTO);
        assertEquals(123,employeeDTO.getId());
    }

    @Test
    @Order(2)
    @DisplayName("2. Test finding all Employees")
    void testFindingAllEmployees() {
        EmployeeDTO employeeDTO = mock(EmployeeDTO.class);
        EmployeeDTO employeeDTO2 = mock(EmployeeDTO.class);
        EmployeeDTO employeeDTO3 = mock(EmployeeDTO.class);
        EmployeeDTO employeeDTO4 = mock(EmployeeDTO.class);

        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        employeeDTOS.add(employeeDTO);
        employeeDTOS.add(employeeDTO2);
        employeeDTOS.add(employeeDTO3);
        employeeDTOS.add(employeeDTO4);

        when(dao.findAll()).thenReturn(employeeDTOS);
        Assertions.assertEquals(4, dao.findAll().size());
    }

    @Test
    @Order(3)
    @DisplayName("3. Test inserting Employee to DB")
    void testInsertingEmployeeToDB() {
        EmployeeDTO employeeDTO = mock(EmployeeDTO.class);
        dao.insert(employeeDTO);
        assertEquals(1, dao.findAll().size());
    }
}
