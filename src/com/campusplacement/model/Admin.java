package com.campusplacement.model;

public class Admin extends User {

    private String department;

    public Admin() {
    }

    public Admin(int userId, String name, String email,
                 String password, String department) {

        super(userId, name, email, password);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public void displayDashboard() {
        System.out.println("\n===== ADMIN DASHBOARD =====");
        System.out.println("Welcome, " + getName());
        System.out.println("1. Manage Students");
        System.out.println("2. Manage Companies");
        System.out.println("3. Manage Jobs");
        System.out.println("4. View Placement Reports");
        System.out.println("5. Logout");
    }
}