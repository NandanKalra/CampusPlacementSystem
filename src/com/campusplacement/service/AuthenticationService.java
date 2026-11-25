
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
        users.add(user);
    }

    public User login(String email, String password) {

        String normalizedEmail = email.trim().toLowerCase(Locale.ROOT);

        for (User user : users) {

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
