package com.sparta.group2;

import com.sparta.group2.controller.EmployeeStorageServiceInterface;
import com.sparta.group2.controller.EmployeeStorageStarter;
import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.factory.FileReader;
import com.sparta.group2.model.storage.EmployeeStorage;
import com.sparta.group2.model.storage.EmployeeStorageService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeStorageServiceInterface service = new EmployeeStorageService();
        long start1 = System.nanoTime();
        EmployeeStorageStarter.start();
        service.getFromFactory();

//        System.out.println("--------------CLEAN DATA--------------");
//        System.out.println();
//        System.out.println();
       EmployeeStorage.getStorage().getCleanList().forEach((integer, employeeDTO) -> System.out.println(employeeDTO.toString()));
        long end1 = System.nanoTime();
        System.out.println("Elapsed Time in seconds: 0."+ (end1-start1) );
//        System.out.println();
//        System.out.println();
//
//        System.out.println("--------------UNCLEAN DATA--------------");
//        System.out.println();
//        System.out.println();
//        EmployeeStorage.getStorage().getUncleanList().forEach((id, employeeDTO) -> System.out.println(employeeDTO.toString()));
//
//        System.out.println();
//        System.out.println();
//
//        System.out.println("Size of clean data: " + cleanList.size());
//        System.out.println("Size of unclean data: " + uncleanList.size());


    }
}
