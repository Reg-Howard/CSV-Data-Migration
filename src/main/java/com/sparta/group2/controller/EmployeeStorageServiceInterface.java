package com.sparta.group2.controller;

import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.storage.EmployeeStorage;

import java.util.ArrayList;
import java.util.List;


public interface EmployeeStorageServiceInterface {
  //Controller that mediates getting data and storing it
  void insertIntoList(EmployeeDTO item);

  void getFromFactory();

  int employeesWithNegativeSalary();

  int listOfDuplicateIDs();

  int employeesWithBadMiddleName();
}
