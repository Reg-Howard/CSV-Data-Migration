package com.sparta.group2.model.sql;

import java.util.List;

public interface InterfaceDAO<T> {

    void insert(T row);
    T findById(int id);
    List<T> findAll();
}
