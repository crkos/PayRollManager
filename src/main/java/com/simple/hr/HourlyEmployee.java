package com.simple.hr;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class HourlyEmployee extends Employee {
    private int hoursWorked;
    public HourlyEmployee(String name) {
        super(name);
    }

    public HourlyEmployee(String name, int hoursWorked) {
        super(name);
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculatePay() {
        return (this.hoursWorked * this.getPayRate()) - ((this.hoursWorked * this.getPayRate()) * 0.3);
    }

    @Override
    public String generatePayStub() {
        Address address = new Address("123 Main St", "Any-town", "TX", "12345");
        Company company = new Company("ABC Company", address);
        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        String strDate = formatter.format(date);

        return "\t\tPay Stub for " + this.getName() + " from " + company.getName() + "\n\t\t" +
                "Pay Date: " + strDate + "\n\t\t" +
                "Net Pay: " + this.hoursWorked * this.getPayRate() + "\n\t\t" +
                "Pay Amount: " + this.calculatePay() + "\n\t\t" +
                "Employee ID: " + getEMPLOYEE_ID() + "\n\t\t" +
                "Thank you for your work! \n\n";
    }

    public static void printStub(String fileName, List<HourlyEmployee> employees) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Employee employee : employees) {
                writer.write(employee.generatePayStub());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
