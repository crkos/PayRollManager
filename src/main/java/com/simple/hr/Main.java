package com.simple.hr;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Department department = new Department("IT");
        Department department2 = new Department("HR");
        Department department3 = new Department("Accounting");

        List<Department> departments = List.of(department, department2, department3);

        Address address = new Address("123 Main St", "Toronto", "ON", "M1M 1M1");
        Company company = new Company("ABC Company", address, departments);


        SalariedEmployee salariedEmployee = new SalariedEmployee("Jane Doe", 80, department);
        SalariedEmployee salariedEmployee2 = new SalariedEmployee("John Doe", 80, department2);
        SalariedEmployee salariedEmployee3 = new SalariedEmployee("Bob Doe", 80, department3);
        SalariedEmployee salariedEmployee4 = new SalariedEmployee("Boba Doe", 80, department3);
        SalariedEmployee salariedEmployee5 = new SalariedEmployee("Bobo Doe", 80, department3);

        String payStubs = "payStubs.txt";

        Employee[] employees = {salariedEmployee, salariedEmployee2, salariedEmployee3, salariedEmployee4, salariedEmployee5};

        List<Employee> employeeList = Arrays.asList(employees);

        //employeeList.forEach(System.out::println);

        Map<String, List<Employee>> groupedEmployees = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        groupedEmployees.forEach((departmentCompany, employeesInDepartment) -> {
            System.out.println(departmentCompany);
            employeesInDepartment.forEach(System.out::println);
        });

    }
}