package com.simple.hr;

public abstract class Employee implements Payable{
    private String name;
    private double payRate;
    private final int EMPLOYEE_ID;
    private Address address;
    private static int nextId = 1000;
    public static double STARTING_PAY_RATE = 7.75;
    protected Department department;

    public Employee(String name) {
        this.name = name;
        EMPLOYEE_ID = getNextId();
        payRate = STARTING_PAY_RATE;
    }

    public Employee(String name, double payRate) {
        this.name = name;
        EMPLOYEE_ID = getNextId();
        this.payRate = payRate;
    }

    public String getName() {
        return name;
    }

    public int getEMPLOYEE_ID() {
        return EMPLOYEE_ID;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void displayAddress() {
        address.getAddress();
    }

    public static int getNextId() {
        int id = nextId;
        return nextId++;
    }

    public String getDepartment() {
        return department.getName();
    }

    @Override
    public String toString() {
        return this.name + " - " + this.EMPLOYEE_ID
                + " - " + this.payRate;
    }

}
