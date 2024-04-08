package com.thinkify.cab_booking.models;

public class Vehicle {
    private String model;
    private String licenseNumber;

    public Vehicle() {
    }

    public Vehicle(String model, String licenseNumber) {
        this.model = model;
        this.licenseNumber = licenseNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    @Override
    public String toString() {
        return "Vehicle [model=" + model + ", licenseNumber=" + licenseNumber + "]";
    }

}
