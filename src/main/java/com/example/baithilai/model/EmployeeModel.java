package com.example.baithilai.model;

import com.example.baithilai.entity.Employee;

import java.util.List;

public interface EmployeeModel {
    boolean save(Employee obj);
    List<Employee> findAll();
}
