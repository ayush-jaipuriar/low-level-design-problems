package com.thinkify.cab_booking.repository;

import java.util.HashMap;
import java.util.Map;

import com.thinkify.cab_booking.models.User;

public class UserRepository {
    private Map<String, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getName(), user);
    }

    public User getUser(String name) {
        return users.get(name);
    }
}
