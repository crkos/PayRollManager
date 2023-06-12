package com.simple.hr;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Contractor implements Payable{
    private String name;
    private int hoursWorked;
    private double partsCost;

    public Contractor(String n, int hours, double parts){
        this.name = n;
        this.hoursWorked = hours;
        this.partsCost = parts;
    }


    @Override
    public double calculatePay() {
        return hoursWorked * partsCost;
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
                "Net Pay: " + this.hoursWorked * this.calculatePay() + "\n\t\t" +
                "Pay Amount: " + this.calculatePay() + "\n\t\t" +
                "Thank you for your work! \n\n";
    }

    public static void printStub(String fileName, List<Contractor> employees) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Contractor employee : employees) {
                writer.write(employee.generatePayStub());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getName() {
        return name;
    }
}
