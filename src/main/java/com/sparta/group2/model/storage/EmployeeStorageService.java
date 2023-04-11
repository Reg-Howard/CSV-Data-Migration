package com.sparta.group2.model.storage;

import com.sparta.group2.controller.EmployeeStorageServiceInterface;
import com.sparta.group2.controller.EmployeeStorageInterface;
import com.sparta.group2.model.EmployeeDTO;
import com.sparta.group2.model.factory.EmployeeFactory;
import com.sparta.group2.model.factory.FileDataReader;

public class EmployeeStorageService implements EmployeeStorageServiceInterface {

  EmployeeStorageInterface storage = EmployeeStorage.getStorage();


  //inserts data into storage based on conditions
  @Override
  public void insertIntoList(EmployeeDTO item) {

      //checks for known errors in the data
    if(  item.getMiddleInitial().contains("FALSE") || item.getSalary() < 0 ){
      storage.addUncleanItem(item);
      //checks if doesn't exist in clean storage already, then adds it to the storage
    } else if(storage.getCleanList().get(item.hashCode()) == null) {
      storage.addCleanItem(item);
      //checks if already exists in the clean storage (duplicates) based on ID
    }  else if (storage.getCleanList().get(item.getId()).getId() == item.getId()){
      storage.addUncleanItem(item);
    }
  }

  @Override
  public void getFromFactory(){
    FileDataReader.readFileLines("src/main/resources/EmployeeRecords.csv");
  }
}
