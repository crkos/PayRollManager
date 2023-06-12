package com.simple.hr;

import java.util.ArrayList;
import java.util.List;


public class Company {
    private String name;
    private final Address address;
    private List<Department> departments = new ArrayList<>();

    public Company(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Company(String name, Address address, List<Department> departments) {
        this.name = name;
        this.address = address;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public List<Department> getDepartments() {
        return departments;
    }
};

