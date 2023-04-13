package com.sparta.group2.model;

import com.sparta.group2.controller.InterfaceDAO;
import com.sparta.group2.model.sql.DAO;
import org.junit.jupiter.api.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class SQLModelChecks {
    DAO dao;

    @BeforeEach
    void setup() {
        dao = mock(DAO.class);
    }

    @Nested
    @DisplayName("DAO Method Checks:")
    public class DAOMethodChecks {
        @Test
        @Order(1)
        @DisplayName("1. Test finding employee by id")
        void testFindingEmployeeById() {
            EmployeeDTO employeeDTO = new EmployeeDTO(123, "Mr", "Marcin", "S", "Jakobik", "M", "teest@12.com", LocalDate.of(1967, 10, 22), LocalDate.of(1967, 10, 22), 1234);
            when(dao.findById(123)).thenReturn(employeeDTO);
            assertEquals(123, dao.findById(123).getId());
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
            List<EmployeeDTO> list = new ArrayList<>();
            list.add(employeeDTO);
            InterfaceDAO<EmployeeDTO> interfaceDAO = mock(DAO.class);
            when(interfaceDAO.findAll()).thenReturn(list);
            interfaceDAO.insert(employeeDTO);
            assertEquals(1, interfaceDAO.findAll().size());
        }

        @Test
        @Order(4)
        @DisplayName("4. Test inserting Employee to DB method")
        void testInsertingToDBMethod(){
            EmployeeDTO employeeDTO = mock(EmployeeDTO.class);
            InterfaceDAO<EmployeeDTO> interfaceDAO = new DAO();
            Assertions.assertThrows(NullPointerException.class, () -> interfaceDAO.insert(employeeDTO));
        }

        @Test
        @Order(5)
        @DisplayName("5. Test Batch Insert DB Method")
        void testBatchInsertingMethod(){
            List<EmployeeDTO> employeeDTOList = new ArrayList<>();
            EmployeeDTO employeeDTO = mock(EmployeeDTO.class);
            employeeDTOList.add(employeeDTO);
            InterfaceDAO<EmployeeDTO> interfaceDAO = new DAO();
            Assertions.assertThrows(NullPointerException.class, () -> interfaceDAO.batchInsert(employeeDTOList));
        }

        @Test
        @Order(6)
        @DisplayName("6. Test Find By ID Method")
        void testFindByIDMethod(){
            InterfaceDAO<EmployeeDTO> interfaceDAO = new DAO();
            Assertions.assertEquals(null, interfaceDAO.findById(1));
        }

        @Test
        @Order(7)
        @DisplayName("7. Test Find All Method")
        void testFindAllMethod(){
            List<EmployeeDTO> nothing = new ArrayList<>();
            InterfaceDAO<EmployeeDTO> interfaceDAO = new DAO();
            Assertions.assertEquals(nothing, interfaceDAO.findAll());
        }
    }
}