package com.sparta.group2.controller;

import com.sparta.group2.model.storage.EmployeeStorage;

public interface EmployeeStorageStarter  {
  //Controller for starting the employee storage
 static EmployeeStorage start(){
    return EmployeeStorage.createEmployeeStorage();
  }
}
