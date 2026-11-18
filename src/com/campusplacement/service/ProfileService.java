
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

        profiles.put(student.getUserId(), profile);
        System.out.println("Profile created successfully.");
    }

    public StudentProfile getProfile(int studentId) {
        return profiles.get(studentId);
    }

    public void updateProfile(int studentId, StudentProfile updatedProfile) {

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
