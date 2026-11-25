
package com.campusplacement.service;

import com.campusplacement.model.User;
import java.util.ArrayList;
import java.util.Locale;

public class AuthenticationService {

    private ArrayList<User> users;

    public AuthenticationService() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {

        if (user == null) {
            System.out.println("Invalid user.");
            return;
        }

        users.add(user);
    }

    public User login(String email, String password) {

        if (email == null || password == null) {
            System.out.println("Invalid email or password.");
            return null;
        }

        String normalizedEmail = email.trim().toLowerCase(Locale.ROOT);

        for (User user : users) {

            if (user.getEmail() == null || user.getPassword() == null) {
                continue;
            }

            String existingEmail = user.getEmail()
                    .trim().toLowerCase(Locale.ROOT);

            if (existingEmail.equals(normalizedEmail)
                    && user.getPassword().equals(password)) {

                System.out.println("Login successful!");
                return user;
            }
        }

        System.out.println("Invalid email or password.");
        return null;
    }

    public void logout() {
        System.out.println("Logged out successfully.");
    }
}
