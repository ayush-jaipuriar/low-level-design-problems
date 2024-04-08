package com.thinkify.cab_booking.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.thinkify.cab_booking.models.Driver;
import com.thinkify.cab_booking.models.Location;
import com.thinkify.cab_booking.models.Ride;
import com.thinkify.cab_booking.services.RideService;

@Controller
public class RideController {
    private final RideService rideService;

    @Autowired
    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    public List<Driver> findRide(String userName, String source, String destination) {
        // Parse source string to extract location information
        String[] sourceInfo = source.replaceAll("[()]", "").split(",");
        int sourceX = Integer.parseInt(sourceInfo[0].trim());
        int sourceY = Integer.parseInt(sourceInfo[1].trim());
        Location sourceLocation = new Location(sourceX, sourceY);

        // Parse destination string to extract location information
        String[] destinationInfo = destination.replaceAll("[()]", "").split(",");
        int destinationX = Integer.parseInt(destinationInfo[0].trim());
        int destinationY = Integer.parseInt(destinationInfo[1].trim());
        Location destinationLocation = new Location(destinationX, destinationY);

        return rideService.findRide(userName, sourceLocation, destinationLocation);
    }

    public Ride chooseRide(String userName, String driverName, String source, String destination) {
        // Parse source and destination into Location instances
        Location sourceLocation = parseLocation(source);
        Location destinationLocation = parseLocation(destination);
        
        return rideService.chooseRide(userName, driverName, sourceLocation, destinationLocation);
    }

    private Location parseLocation(String locationString) {
        String[] locationInfo = locationString.replaceAll("[()]", "").split(",");
        int x = Integer.parseInt(locationInfo[0].trim());
        int y = Integer.parseInt(locationInfo[1].trim());
        return new Location(x, y);
    }
}
