
package com.campusplacement.main;

import com.campusplacement.utility.InputHelper;

public class MenuManager {


    public int showMainMenu() {

        System.out.println("\n=================================");
        System.out.println(" CAMPUS PLACEMENT MANAGEMENT");
        System.out.println("=================================");
        System.out.println("1. Register Student");
        System.out.println("2. Student Login");
        System.out.println("3. View Students by Branch");
        System.out.println("4. Check Placement Eligibility");
        System.out.println("5. View Companies and Salary Packages");
        System.out.println("6. Exit");
        System.out.println("=================================");

        return InputHelper.getInt("Enter your choice: ");
    }


    public int showStudentMenu() {

        System.out.println("\n=================================");
        System.out.println("       STUDENT DASHBOARD");
        System.out.println("=================================");
        System.out.println("1. View Profile");
        System.out.println("2. View Student Details");
        System.out.println("3. Check Eligibility");
        System.out.println("4. Logout");
        System.out.println("=================================");

        return InputHelper.getInt("Enter your choice: ");
    }


    public int showBranchMenu() {

        System.out.println("\n=================================");
        System.out.println("          SELECT BRANCH");
        System.out.println("=================================");
        System.out.println("1. Computer Science");
        System.out.println("2. BBA");
        System.out.println("3. ECE");
        System.out.println("4. Interior Designing");
        System.out.println("5. Pharma");
        System.out.println("6. Mechanical");
        System.out.println("=================================");

        return InputHelper.getInt("Choose your branch: ");
    }


    public int showCompanyMenu() {

        System.out.println("\n=================================");
        System.out.println("       COMPANY AND SALARY MENU");
        System.out.println("=================================");
        System.out.println("1. View All Companies");
        System.out.println("2. View Companies By Branch");
        System.out.println("3. View Highest Salary Package By Branch");
        System.out.println("4. Back to Main Menu");
        System.out.println("=================================");

        return InputHelper.getInt("Enter your choice: ");
    }
}
