package com.example.baithilai.constant;

public class SqlConstant {
    public static final String EMPLOYEE_INSERT = "INSERT INTO employee (fullName, birthday, address, position, department) values (?, ?, ?, ?,?)";
    public static final String EMPLOYEE_SELECT_ALL = "SELECT * FROM employee";
    public static final String EMPLOYEE_FIELD_ID = "id";
    public static final String EMPLOYEE_FIELD_FULLNAME = "fullName";

    public static final String EMPLOYEE_FIELD_ADDRESS = "address";
    public static final String EMPLOYEE_FIELD_POSITION = "position";
    public static final String EMPLOYEE_FIELD_DEPARTMENT = "department";
    public static final String EMPLOYEE_FIELD_BIRTHDAY = "birthday";
}
