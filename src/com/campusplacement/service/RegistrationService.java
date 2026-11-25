package com.campusplacement.service;

import com.campusplacement.model.User;
import java.util.ArrayList;
import java.util.Locale;

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

        String email = user.getEmail().trim().toLowerCase(Locale.ROOT);

        for (User existingUser : registeredUsers) {

            if (existingUser == null || existingUser.getEmail() == null) {
                continue;
            }

            String existingEmail = existingUser.getEmail()
                    .trim().toLowerCase(Locale.ROOT);

            if (existingEmail.equals(email)) {
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