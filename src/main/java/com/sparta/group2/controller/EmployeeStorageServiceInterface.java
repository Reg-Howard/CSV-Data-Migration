package com.sparta.group2.controller;

import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.factory.FileReader;

public interface EmployeeStorageServiceInterface {
  //Controller that mediates getting data and storing it
  void insertIntoList(EmployeeDTO item);

   void getFromFactory();
}
