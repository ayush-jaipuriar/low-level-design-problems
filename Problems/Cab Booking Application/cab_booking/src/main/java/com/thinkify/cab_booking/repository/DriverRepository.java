package com.thinkify.cab_booking.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.thinkify.cab_booking.models.Driver;

public class DriverRepository {
    private Map<String, Driver> drivers = new HashMap<>();

    public void addDriver(Driver driver) {
        drivers.put(driver.getName(), driver);
    }

    public Driver getDriver(String name) {
        return drivers.get(name);
    }

    public List<Driver> getDrivers() {
        return new ArrayList<>(drivers.values());
    }
}
