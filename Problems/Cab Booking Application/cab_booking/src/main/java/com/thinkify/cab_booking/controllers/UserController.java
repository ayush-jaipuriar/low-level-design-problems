package com.thinkify.cab_booking.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.thinkify.cab_booking.models.User;
import com.thinkify.cab_booking.repository.UserRepository;

@Controller
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(String userDetails) {
        // Parse userDetails string to extract user information
        String[] details = userDetails.split(",");
        String name = details[0].trim();
        String gender = details[1].trim();
        int age = Integer.parseInt(details[2].trim());

        // Create a new User instance
        User user = new User(name, gender, age);

        // Add the user to the repository
        userRepository.addUser(user);
    }
}
