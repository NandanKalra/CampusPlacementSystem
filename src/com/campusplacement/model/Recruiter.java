package com.campusplacement.model;

public class Recruiter extends User {

    private int companyId;
    private String designation;

    public Recruiter() {
    }

    public Recruiter(int userId, String name, String email,
                     String password, int companyId, String designation) {

        super(userId, name, email, password);

        this.companyId = companyId;
        this.designation = designation;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public void displayDashboard() {
        System.out.println("\n===== RECRUITER DASHBOARD =====");
        System.out.println("Welcome, " + getName());
        System.out.println("1. View Company Profile");
        System.out.println("2. Post Jobs");
        System.out.println("3. View Applications");
        System.out.println("4. Schedule Interviews");
        System.out.println("5. Logout");
    }
}