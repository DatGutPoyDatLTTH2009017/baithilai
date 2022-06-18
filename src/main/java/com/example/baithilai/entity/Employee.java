package com.example.baithilai.entity;

import java.util.HashMap;

public class Employee {
    public static com.example.baithilai.entity.EmployeeBuilder EmployeeBuilder;
    private int id;
    private String fullName;
    private String birthday;
    private String address;
    private String position;
    private String department;

    
    public Employee(int id, String fullName, String birthday, String address, String position, String department) {
        this.id = id;
        this.fullName = fullName;
        this.birthday = birthday;
        this.address = address;
        this.position = position;
        this.department = department;
    }

    public Employee() {
        this.fullName = "";
        this.address = "";
        this.position = "";
        this.department = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Employee(HashMap<String, String> errors) {
        this.errors = errors;
    }

    public HashMap<String, String> getErrors() {
        return errors;
    }

    public void setErrors(HashMap<String, String> errors) {
        this.errors = errors;
    }

    private HashMap<String, String> errors = new HashMap<>();

    public boolean isValid() {
        checkValid();
        return errors.size() == 0;
    }
    private void checkValid() {
        if (fullName == null || fullName.length() == 0) {
            errors.put("fullName", "Please enter fullName");
        }
        if (address == null || address.length() == 0) {
            errors.put("address", "Please enter address");
        }
        if (position == null || position.length() == 0) {
            errors.put("address", "Please enter address");
        }
        if (department == null || department.length() == 0) {
            errors.put("department", "Please enter department");
        }
    }
}
