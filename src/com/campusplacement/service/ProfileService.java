package com.campusplacement.service;

import com.campusplacement.model.Student;
import com.campusplacement.model.StudentProfile;

import java.util.HashMap;

public class ProfileService {

    private HashMap<Integer, StudentProfile> profiles;

    public ProfileService() {
        profiles = new HashMap<>();
    }

    public void createProfile(Student student, StudentProfile profile) {

        if (student == null || profile == null) {
            System.out.println("Invalid profile details.");
            return;
        }

        int studentId = student.getUserId();

        if (profiles.containsKey(studentId)) {
            System.out.println("Profile already exists.");
            return;
        }

        profiles.put(studentId, profile);
        System.out.println("Profile created successfully.");
    }

    public StudentProfile getProfile(int studentId) {
        return profiles.get(studentId);
    }

    public void updateProfile(int studentId, StudentProfile updatedProfile) {

        if (updatedProfile == null) {
            System.out.println("Invalid profile details.");
            return;
        }

        if (profiles.containsKey(studentId)) {
            profiles.put(studentId, updatedProfile);
            System.out.println("Profile updated successfully.");
        } else {
            System.out.println("Profile not found.");
        }
    }

    public void displayProfile(int studentId) {

        StudentProfile profile = profiles.get(studentId);

        if (profile != null) {
            profile.displayProfile();
        } else {
            System.out.println("Profile not found.");
        }
    }
}