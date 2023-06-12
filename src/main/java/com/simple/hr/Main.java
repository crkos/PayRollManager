package com.simple.hr;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        Contractor salariedEmployee = new Contractor("Jane Doe", 80, 50);
        Contractor salariedEmployee2 = new Contractor("John Doe", 80, 50);
        Contractor salariedEmployee3 = new Contractor("Bob Doe", 80, 50);

        String payStubs = "payStubs.txt";

        List<Contractor> employees = List.of(salariedEmployee, salariedEmployee2, salariedEmployee3);

        Contractor.printStub(payStubs, employees);

    }
}