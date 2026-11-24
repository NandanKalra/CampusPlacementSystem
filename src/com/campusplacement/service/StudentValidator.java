package com.campusplacement.service;

import com.campusplacement.model.Student;
import com.campusplacement.exceptions.ProjectException;

public class StudentValidator {

    public void validateStudent(Student student) throws ProjectException {

        if (student == null) {
            throw new ProjectException("Student details cannot be empty.");
        }

        String name = student.getName();

        if (name == null || !name.trim().matches("[a-zA-Z ]{2,30}")) {
            throw new ProjectException(
                "Name must contain only letters and spaces (2-30 characters)."
            );
        }

        String email = student.getEmail();

        if (email == null ||
            !email.trim().matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new ProjectException("Please enter a valid email.");
        }

        String password = student.getPassword();

        if (password == null ||
            password.length() < 8 || password.length() > 20) {
            throw new ProjectException(
                "Password must contain between 8 and 20 characters."
            );
        }

        double cgpa = student.getCgpa();

        if (!Double.isFinite(cgpa) || cgpa < 0 || cgpa > 10) {
            throw new ProjectException("CGPA must be between 0 and 10.");
        }

        int semester = student.getSemester();

        if (semester < 1 || semester > 8) {
            throw new ProjectException("Semester must be between 1 and 8.");
        }

        String branch = student.getBranch();

        if (!isValidBranch(branch)) {
            throw new ProjectException("Please select a valid branch.");
        }
    }

    public boolean isValidBranch(String branch) {

        if (branch == null) {
            return false;
        }

        branch = branch.trim();

        String[] branches = {
            "Computer Science",
            "BBA",
            "ECE",
            "Interior Designing",
            "Pharma",
            "Mechanical"
        };

        for (String validBranch : branches) {
            if (validBranch.equalsIgnoreCase(branch)) {
                return true;
            }
        }

        return false;
    }
}