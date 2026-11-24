package com.campusplacement.service;

import com.campusplacement.model.User;
import java.util.ArrayList;

public class RegistrationService {

    private ArrayList<User> registeredUsers;

    public RegistrationService() {
        registeredUsers = new ArrayList<>();
    }

    public boolean registerUser(User user) {

        if (user == null || user.getEmail() == null) {
            System.out.println("Invalid user details.");
            return false;
        }

        for (User existingUser : registeredUsers) {

            if (existingUser.getEmail() != null &&
                existingUser.getEmail().equalsIgnoreCase(user.getEmail())) {

                System.out.println("Email is already registered.");
                return false;
            }
        }

        registeredUsers.add(user);
        System.out.println("Registration successful!");
        return true;
    }

    public ArrayList<User> getRegisteredUsers() {
        return registeredUsers;
    }
}