
package com.campusplacement.model;

public class StudentProfile {
    private String phone;
    private String address;
    private String dateOfBirth;
    private String linkedIn;
    private String github;

    public StudentProfile() {}

    public StudentProfile(String phone, String address,
                          String dateOfBirth, String linkedIn, String github) {
        this.phone = phone;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.linkedIn = linkedIn;
        this.github = github;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLinkedIn() {
        return linkedIn;
    }

    public void setLinkedIn(String linkedIn) {
        this.linkedIn = linkedIn;
    }

    public String getGithub() {
        return github;
    }

    public void setGithub(String github) {
        this.github = github;
    }

    public void displayProfile() {
        System.out.println("\n===== STUDENT PROFILE =====");
        System.out.println("Phone: " + phone);
        System.out.println("Address: " + address);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("LinkedIn: " + linkedIn);
        System.out.println("GitHub: " + github);
    }
}
