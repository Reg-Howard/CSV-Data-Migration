package com.sparta.group2;


import com.sparta.group2.controller.EmployeeStorageServiceInterface;
import com.sparta.group2.controller.EmployeeStorageStarter;
import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.sql.ConnectionProvider;
import com.sparta.group2.model.sql.DAO;
import com.sparta.group2.model.sql.DatabaseSetUp;
import com.sparta.group2.model.storage.EmployeeStorageService;
import com.sparta.group2.view.CLI;

import java.util.List;

public class Main {

    public static void main(String[] args) {

//        long start1 = System.nanoTime();
//
//      long end1 = System.nanoTime();
//
//        System.out.println("Time taken: " + (end1 - start1));
      EmployeeStorageStarter.start();

      //DatabaseSetUp.setUpDB();
      DatabaseSetUp.populateDB();
//      DAO dao = new DAO();
//      List<EmployeeDTO> dto = dao.findAll();
    //  dto.forEach(System.out::println);
//        CLI cli = new CLI();
//        cli.run();

    }
}
