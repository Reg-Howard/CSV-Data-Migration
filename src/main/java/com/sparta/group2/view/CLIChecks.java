package com.sparta.group2.view;

import com.sparta.group2.controller.EmployeeStorageServiceInterface;
import com.sparta.group2.controller.EmployeeStorageStarter;
import com.sparta.group2.controller.InterfaceDAO;
import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.factory.EmployeeFactory;
import com.sparta.group2.model.sql.DAO;
import com.sparta.group2.model.sql.DatabaseSetUp;
import com.sparta.group2.model.storage.EmployeeStorage;
import com.sparta.group2.model.storage.EmployeeStorageService;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CLIChecks {

    public static HashMap<Integer, EmployeeDTO> cleanList;
    public static HashMap<Integer, EmployeeDTO> uncleanList;

    public static InterfaceDAO dao;
    public static List<EmployeeDTO> dto;

    @BeforeAll
    static void init(){
        EmployeeStorageStarter.start();
        EmployeeStorageServiceInterface employeeServiceInterface = new EmployeeStorageService();
        employeeServiceInterface.getFromFactory();
        DatabaseSetUp.setUpAndPopulateDB();

        cleanList = EmployeeStorage.getStorage().getCleanList();
        uncleanList = EmployeeStorage.getStorage().getUncleanList();

        dao = new DAO();
        dto = dao.findAll();

    }

//    @Test
//    @DisplayName("Testing cli.run() method does not throw any exceptions")
//    void testCliRunMethod(){
//        Assertions.assertDoesNotThrow(CLI.run());
//    }

    @Test
    @DisplayName("Test whether the clean list of employee is not null")
    void testCLeanListIsNotNull(){
        Assertions.assertNotNull(cleanList);
    }

    @Test
    @DisplayName("Test whether the unclean list of employee is not null")
    void testUncleanListIsNotNull(){
        Assertions.assertNotNull(uncleanList);
    }

    @Test
    @DisplayName("Verifying the size of the clean list equals 9921")
    void testSizeOfCleanList(){
        Assertions.assertEquals(9921,cleanList.size());
    }

    @Test
    @DisplayName("Verifying the size of the unClean list equals 79")
    void testSizeOfUnCleanList(){
        Assertions.assertEquals(79,uncleanList.size());
    }

    @Test
    @DisplayName("Test whether the employeeDTO list of employees is not null")
    void testEmployeeDTOIsNotNull(){

        System.out.println(dto.size());
        Assertions.assertNotNull(dto);
    }

    @Test
    @DisplayName("Verifying the size of the employeeDTO list of employees equals 9921")
    void testSizeOfEmployeeDTOList(){
        Assertions.assertEquals(9921,dto.size());
    }
}