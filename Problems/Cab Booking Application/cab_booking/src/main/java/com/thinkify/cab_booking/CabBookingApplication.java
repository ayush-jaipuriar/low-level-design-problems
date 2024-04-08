package com.thinkify.cab_booking;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.thinkify.cab_booking.controllers.DriverController;
import com.thinkify.cab_booking.controllers.RideController;
import com.thinkify.cab_booking.controllers.UserController;
import com.thinkify.cab_booking.models.Driver;
import com.thinkify.cab_booking.models.Ride;
import com.thinkify.cab_booking.repository.DriverRepository;
import com.thinkify.cab_booking.repository.UserRepository;
import com.thinkify.cab_booking.services.RideService;

@SpringBootApplication
public class CabBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CabBookingApplication.class, args);
		Test test = new Test();
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository userRepository, DriverRepository driverRepository,
			RideService rideService) {
		return args -> {
			UserController userController = new UserController(userRepository);
			DriverController driverController = new DriverController(driverRepository);
			RideController rideController = new RideController(rideService);

			// Onboard users
			userController.addUser("Abhishek, M, 23");
			userController.addUser("Rahul, M, 29");
			userController.addUser("Nandini, F, 22");

			// Onboard drivers
			driverController.addDriver("Driver1, M, 22", "Swift:KA-01-12345", "(10,1)");
			driverController.addDriver("Driver2, M, 29", "Swift:KA-01-12345", "(11,10)");
			driverController.addDriver("Driver3, M, 24", "Swift:KA-01-12345", "(5,3)");

			// Find rides
			List<Driver> availableDrivers = rideController.findRide("Abhishek", "(0,0)", "(20,1)");
			System.out.println("Abhishek trying to get a ride from (0,0) to (20,1):");
			System.out.println(availableDrivers.isEmpty()
					? "No ride found [Since all the drivers are more than 5 units away from user]"
					: availableDrivers);
			System.out.println();

			availableDrivers = rideController.findRide("Rahul", "(10,0)", "(15,3)");
			System.out.println("Rahul trying to get a ride from (10,0) to (15,3):");
			System.out.println(availableDrivers.isEmpty() ? "No ride found" : "Driver1 [Available]");
			System.out.println();

			availableDrivers = rideController.findRide("Nandini", "(15,6)", "(20,4)");
			System.out.println("Nandini trying to get a ride from (15,6) to (20,4):");
			System.out.println(availableDrivers.isEmpty() ? "No ride found [Driver one is set to not available]"
					: availableDrivers);
			System.out.println();

			// Choose ride
			Ride ride = rideController.chooseRide("Rahul", "Driver1", "(10,0)", "(15,3)");
			System.out.println("Ride chosen: " + ride);
		};
	}

}
