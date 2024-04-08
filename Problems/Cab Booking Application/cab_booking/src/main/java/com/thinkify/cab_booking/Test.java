package com.thinkify.cab_booking;
// Driver.java

import java.util.List;

import com.thinkify.cab_booking.controllers.DriverController;
import com.thinkify.cab_booking.controllers.RideController;
import com.thinkify.cab_booking.controllers.UserController;
import com.thinkify.cab_booking.models.Driver;
import com.thinkify.cab_booking.models.Ride;
import com.thinkify.cab_booking.repository.DriverRepository;
import com.thinkify.cab_booking.repository.UserRepository;
import com.thinkify.cab_booking.services.RideService;

public class Test {
    private UserRepository userRepository;
    private DriverRepository driverRepository;
    private RideService rideService;
    private UserController userController;
    private DriverController driverController;
    private RideController rideController;
    
    public Test() {
        userRepository = new UserRepository();
        driverRepository = new DriverRepository();
        rideService = new RideService(userRepository, driverRepository);
        userController = new UserController(userRepository);
        driverController = new DriverController(driverRepository);
        rideController = new RideController(rideService);
    }
    
    public void runDemo() {
        UserRepository userRepository = new UserRepository();
        DriverRepository driverRepository = new DriverRepository();
        RideService rideService = new RideService(userRepository, driverRepository);

        UserController userController = new UserController(userRepository);
        DriverController driverController = new DriverController(driverRepository);
        RideController rideController = new RideController(rideService);

        // Onboard users
        userController.addUser("Abhishek, M, 23");
        userController.addUser("Rahul, M, 29");
        userController.addUser("Nandini, F, 22");

        // Onboard drivers
        driverController.addDriver("Driver1, M, 22", "Swift, KA-01-12345", "(10,1)");
        driverController.addDriver("Driver2, M, 29", "Swift, KA-01-12345", "(11,10)");
        driverController.addDriver("Driver3, M, 24", "Swift, KA-01-12345", "(5,3)");

        // Find rides
        List<Driver> availableDrivers = rideController.findRide("Abhishek", "(0,0)", "(20,1)");
        System.out.println(availableDrivers.isEmpty() ? "No ride found" : availableDrivers);

        availableDrivers = rideController.findRide("Rahul", "(10,0)", "(15,3)");
        System.out.println(availableDrivers.isEmpty() ? "No ride found" : availableDrivers);

        availableDrivers = rideController.findRide("Nandini", "(15,6)", "(20,4)");
        System.out.println(availableDrivers.isEmpty() ? "No ride found" : availableDrivers);

        // Choose ride
        Ride ride = rideController.chooseRide("Rahul", "Driver1", "(10,0)", "(15,3)");
        System.out.println("Ride chosen: " + ride);
    }
    
    public static void main(String[] args) {
        return;
    }
}
