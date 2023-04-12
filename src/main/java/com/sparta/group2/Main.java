package com.sparta.group2;


import com.sparta.group2.controller.EmployeeStorageServiceInterface;
import com.sparta.group2.controller.EmployeeStorageStarter;
import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.sql.ConnectionProvider;
import com.sparta.group2.model.sql.DAO;
import com.sparta.group2.model.sql.DatabaseSetUp;
import com.sparta.group2.model.storage.EmployeeStorage;
import com.sparta.group2.model.storage.EmployeeStorageService;
import com.sparta.group2.view.CLI;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        CLI cli = new CLI();
        cli.run();

//        long start1 = System.nanoTime();

//
//      EmployeeStorageStarter.start();
//      EmployeeStorageServiceInterface employeeStorageServiceInterface = new EmployeeStorageService();
//      employeeStorageServiceInterface.getFromFactory();
//      DatabaseSetUp.setUpAndPopulateDB();

//      DAO dao = new DAO();
//      List<EmployeeDTO> dto = dao.findAll();
//      dto.forEach(System.out::println);
        // System.out.println(dto.size());
//      long end1 = System.nanoTime();
//        System.out.println("Time taken: " + (end1 - start1));

    }
}
