package com.campusplacement.model;

public class Student extends User {

    private String branch;
    private int semester;
    private double cgpa;

    public Student() {
    }

    public Student(int userId, String name, String email, String password,
                   String branch, int semester, double cgpa) {

        super(userId, name, email, password);

        this.branch = branch;
        this.semester = semester;
        this.cgpa = cgpa;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    @Override
    public void displayDashboard() {
        System.out.println("\n===== STUDENT DASHBOARD =====");
        System.out.println("Welcome, " + getName());
        System.out.println("1. View Profile");
        System.out.println("2. View Available Jobs");
        System.out.println("3. Apply for Job");
        System.out.println("4. Track Applications");
        System.out.println("5. Logout");
    }
}