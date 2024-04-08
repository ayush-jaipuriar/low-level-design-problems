package com.thinkify.cab_booking.services;

import java.util.ArrayList;
import java.util.List;

import com.thinkify.cab_booking.custom_exceptions.DriverNotAvailableException;
import com.thinkify.cab_booking.custom_exceptions.DriverNotFoundException;
import com.thinkify.cab_booking.custom_exceptions.UserNotFoundException;
import com.thinkify.cab_booking.models.Driver;
import com.thinkify.cab_booking.models.Location;
import com.thinkify.cab_booking.models.Ride;
import com.thinkify.cab_booking.models.User;
import com.thinkify.cab_booking.repository.DriverRepository;
import com.thinkify.cab_booking.repository.UserRepository;

public class RideService {
    private UserRepository userRepository;
    private DriverRepository driverRepository;

    public RideService(UserRepository userRepository, DriverRepository driverRepository) {
        this.userRepository = userRepository;
        this.driverRepository = driverRepository;
    }

    public List<Driver> findRide(String userName, Location source, Location destination) {
        User user = userRepository.getUser(userName);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : driverRepository.getDrivers()) {
            if (driver.isAvailable() && driver.getCurrentLocation().distanceFrom(source) <= 5) {
                availableDrivers.add(driver);
            }
        }

        return availableDrivers;
    }

    public Ride chooseRide(String userName, String driverName, Location source, Location destination) {
        User user = userRepository.getUser(userName);
        if (user == null) {
            throw new UserNotFoundException("User not found");
        }

        Driver driver = driverRepository.getDriver(driverName);
        if (driver == null) {
            throw new DriverNotFoundException("Driver not found");
        }

        // Create and return a new Ride instance
        // Check if the driver is available and within the acceptable distance from the
        // source
        if (!driver.isAvailable()) {
            throw new DriverNotAvailableException("Driver is not available");
        }

        // Create a new Ride instance
        Ride ride = new Ride();
        ride.setUser(user);
        ride.setDriver(driver);
        ride.setSource(source);
        ride.setDestination(destination);

        // Mark the driver as unavailable
        driver.setAvailable(false);

        return ride;
    }
}
