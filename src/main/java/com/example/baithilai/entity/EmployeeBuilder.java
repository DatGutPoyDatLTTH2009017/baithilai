package com.example.baithilai.entity;public final class EmployeeBuilder {
    private int id;
    private String fullName;
    private String birthday;
    private String address;
    private String position;
    private String department;

    private EmployeeBuilder() {
    }

    public static EmployeeBuilder anEmployee() {
        return new EmployeeBuilder();
    }

    public EmployeeBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public EmployeeBuilder withFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public EmployeeBuilder withBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    public EmployeeBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public EmployeeBuilder withPosition(String position) {
        this.position = position;
        return this;
    }

    public EmployeeBuilder withDepartment(String department) {
        this.department = department;
        return this;
    }

    public Employee build() {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setFullName(fullName);
        employee.setBirthday(birthday);
        employee.setAddress(address);
        employee.setPosition(position);
        employee.setDepartment(department);
        return employee;
    }
}
