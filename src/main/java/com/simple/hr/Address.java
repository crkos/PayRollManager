package com.simple.hr;

public class Address {
    private String street;
    private String city;
    private String province;
    private String zip;

    public Address(String street, String city, String province, String zip) {
        this.street = street;
        this.city = city;
        this.province = province;
        this.zip = zip;
    }

    public void getAddress() {
        System.out.println(street + ", " + city + ", " + province + ", " + zip);
    }

}
