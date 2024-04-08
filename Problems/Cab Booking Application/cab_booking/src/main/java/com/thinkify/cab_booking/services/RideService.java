package com.thinkify.cab_booking.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkify.cab_booking.custom_exceptions.DriverNotAvailableException;
import com.thinkify.cab_booking.custom_exceptions.DriverNotFoundException;
import com.thinkify.cab_booking.custom_exceptions.UserNotFoundException;
import com.thinkify.cab_booking.models.Driver;
import com.thinkify.cab_booking.models.Location;
import com.thinkify.cab_booking.models.Ride;
import com.thinkify.cab_booking.models.User;
import com.thinkify.cab_booking.repository.DriverRepository;
import com.thinkify.cab_booking.repository.UserRepository;

@Service
public class RideService {
    private final UserRepository userRepository;
    private final DriverRepository driverRepository;

    @Autowired
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

        // Sort the available drivers based on their distance from the source
        availableDrivers.sort((d1, d2) -> {
            double dist1 = d1.getCurrentLocation().distanceFrom(source);
            double dist2 = d2.getCurrentLocation().distanceFrom(source);
            return Double.compare(dist1, dist2);
        });

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

        if (!driver.isAvailable() || driver.getCurrentLocation().distanceFrom(source) > 5) {
            throw new DriverNotAvailableException("Driver is not available or too far from the source");
        }

        Ride ride = new Ride(user, driver, source, destination);
        driver.setAvailable(false);

        return ride;
    }
}
