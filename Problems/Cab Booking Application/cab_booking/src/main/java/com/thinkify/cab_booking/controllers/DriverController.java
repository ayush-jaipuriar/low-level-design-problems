package com.thinkify.cab_booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.thinkify.cab_booking.models.Driver;
import com.thinkify.cab_booking.models.Location;
import com.thinkify.cab_booking.models.Vehicle;
import com.thinkify.cab_booking.repository.DriverRepository;

@Controller
public class DriverController {
    private final DriverRepository driverRepository;

    @Autowired
    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public void addDriver(String driverDetails, String vehicleDetails, String currentLocation) {
        String[] driverInfo = driverDetails.split(",");
        String name = driverInfo[0].trim();
        String gender = driverInfo[1].trim();
        int age = Integer.parseInt(driverInfo[2].trim());

        String[] vehicleInfo = driverInfo[3].split(":");
        String model = vehicleInfo[0].trim();
        String licenseNumber = vehicleInfo[1].trim();

        String[] locationInfo = driverInfo[4].replaceAll("[()]", "").split(",");
        int x = Integer.parseInt(locationInfo[0].trim());
        int y = Integer.parseInt(locationInfo[1].trim());

        Vehicle vehicle = new Vehicle(model, licenseNumber);
        Location currentLocationObj = new Location(x, y);
        Driver driver = new Driver(name, gender, age, vehicle, currentLocationObj);

        driverRepository.addDriver(driver);
    }
}
