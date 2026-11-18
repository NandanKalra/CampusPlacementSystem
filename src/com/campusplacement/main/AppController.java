
package com.campusplacement.main;

import com.campusplacement.model.Student;
import com.campusplacement.model.StudentProfile;
import com.campusplacement.model.User;

import com.campusplacement.service.AuthenticationService;
import com.campusplacement.service.RegistrationService;
import com.campusplacement.service.StudentService;
import com.campusplacement.service.ProfileService;
import com.campusplacement.service.EligibilityService;
import com.campusplacement.service.StudentValidator;

import com.campusplacement.utility.IdGenerator;
import com.campusplacement.utility.InputHelper;

import com.campusplacement.exceptions.ProjectException;

public class AppController {

    private MenuManager menuManager;
    private AuthenticationService authenticationService;
    private RegistrationService registrationService;
    private StudentService studentService;
    private ProfileService profileService;
    private EligibilityService eligibilityService;
    private StudentValidator studentValidator;

    public AppController() {

        menuManager = new MenuManager();
        authenticationService = new AuthenticationService();
        registrationService = new RegistrationService();
        studentService = new StudentService();
        profileService = new ProfileService();
        eligibilityService = new EligibilityService();
        studentValidator = new StudentValidator();

        // Load existing students
        for (Student student : studentService.getStudents()) {
            authenticationService.addUser(student);
            registrationService.registerUser(student);
        }
    }

    
public void start() {

    boolean running = true;

    while (running) {

        int choice = menuManager.showMainMenu();

        switch (choice) {

            case 1:
                registerStudent();
                break;

            case 2:
                studentLogin();
                break;

            case 3:
                viewStudentsByBranch();
                break;

            case 4:
                checkEligibility();
                break;

            case 5:
                System.out.println("Opening Company Menu...");
                viewCompanies();
                break;

            case 6:
                running = false;
                System.out.println("Thank you for using Campus Placement Management System!");
                break;

            default:
                System.out.println("Invalid choice. Try again.");
        }
    }
}


    private void registerStudent() {

        System.out.println("\n========== STUDENT REGISTRATION ==========");

        String name = InputHelper.getString("Enter your name: ");
        String email = InputHelper.getString("Enter your email: ");
        String password = InputHelper.getString("Create password: ");

        String branch = selectBranch();

        int semester = InputHelper.getInt("Enter semester (1-8): ");
        double cgpa = InputHelper.getDouble("Enter CGPA (0-10): ");

        Student student = new Student(
                IdGenerator.generateStudentId(),
                name,
                email,
                password,
                branch,
                semester,
                cgpa
        );

        try {

            studentValidator.validateStudent(student);

            boolean registered = registrationService.registerUser(student);

            if (registered) {

                authenticationService.addUser(student);
                studentService.addStudent(student);

                StudentProfile profile = new StudentProfile();
                profileService.createProfile(student, profile);

                System.out.println("\nRegistration successful!");
                System.out.println("Your Student ID: " + student.getUserId());

            } else {

                System.out.println("\nEmail already registered.");

            }

        } catch (ProjectException e) {

            System.out.println("\nRegistration failed: " + e.getMessage());

        }
    }


    private String selectBranch() {

        while (true) {

            menuManager.showBranchMenu();

            int choice = InputHelper.getInt("Select branch: ");

            switch (choice) {

                case 1:
                    return "Computer Science";

                case 2:
                    return "BBA";

                case 3:
                    return "ECE";

                case 4:
                    return "Interior Designing";

                case 5:
                    return "Pharma";

                case 6:
                    return "Mechanical";

                default:
                    System.out.println("Invalid branch. Select again.");
            }
        }
    }


    private void studentLogin() {

        System.out.println("\n========== STUDENT LOGIN ==========");

        String email = InputHelper.getString("Enter email: ");
        String password = InputHelper.getString("Enter password: ");

        User user = authenticationService.login(email, password);

        if (user instanceof Student) {

            Student student = (Student) user;

            System.out.println("\nWelcome, " + student.getName());

            showStudentDashboard(student);

        } else if (user != null) {

            System.out.println("This menu is for students only.");

        }
    }


    private void showStudentDashboard(Student student) {

        boolean loggedIn = true;

        while (loggedIn) {

            int choice = menuManager.showStudentMenu();

            switch (choice) {

                case 1:
                    profileService.displayProfile(student.getUserId());
                    break;

                case 2:
                    student.displayDashboard();
                    break;

                case 3:
                    eligibilityService.checkEligibility(student);
                    break;

                case 4:
                    System.out.println("Logged out successfully.");
                    loggedIn = false;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }


    private void viewStudentsByBranch() {

        System.out.println("\n========== STUDENT COUNT BY BRANCH ==========");

        String branch = selectBranch();

        studentService.displayStudentCountByBranch(branch);
    }


    private void checkEligibility() {

        System.out.println("\n========== PLACEMENT ELIGIBILITY ==========");

        int studentId = InputHelper.getInt("Enter Student ID: ");

        Student student = studentService.findStudentById(studentId);

        if (student == null) {

            System.out.println("Student not found.");

            return;
        }

        eligibilityService.checkEligibility(student);
    }


    private void viewCompanies() {

    boolean running = true;
    System.out.println("viewCompanies() function called!");

    while (running) {

        System.out.println("\n========== COMPANY AND SALARY MENU ==========");
        System.out.println("1. View All Companies");
        System.out.println("2. View Companies By Branch");
        System.out.println("3. View Highest Salary Package By Branch");
        System.out.println("4. Back to Main Menu");

        int choice = InputHelper.getInt("Enter your choice: ");

        switch (choice) {

            case 1:
                displayAllCompanies();
                break;

            case 2:
                displayCompaniesByBranch(selectBranch());
                break;

            case 3:
                displayHighestPackage(selectBranch());
                break;

            case 4:
                running = false;
                break;

            default:
                System.out.println("Invalid choice.");
        }
    }
}

    private String[][] getCompaniesByBranch(String branch) {

        switch (branch) {

            case "Computer Science":
                return new String[][] {
                    {"TCS", "Software Engineer", "3.5-7", "6.0"},
                    {"Infosys", "System Engineer", "3.5-8", "6.0"},
                    {"Accenture", "Associate Software Engineer", "4-9", "6.5"}
                };

            case "BBA":
                return new String[][] {
                    {"Deloitte", "Business Analyst", "4-8", "6.5"},
                    {"EY", "Audit Associate", "3.5-7", "6.0"},
                    {"HDFC Bank", "Relationship Manager", "3-6", "6.0"}
                };

            case "ECE":
                return new String[][] {
                    {"Qualcomm", "Embedded Engineer", "5-12", "7.0"},
                    {"Bosch", "Electronics Engineer", "4-9", "6.5"},
                    {"Samsung", "Hardware Engineer", "5-11", "7.0"}
                };

            case "Interior Designing":
                return new String[][] {
                    {"Livspace", "Interior Designer", "3-7", "6.0"},
                    {"Godrej Interio", "Design Associate", "3-6", "6.0"},
                    {"Asian Paints", "Design Consultant", "3.5-7", "6.0"}
                };

            case "Pharma":
                return new String[][] {
                    {"Sun Pharma", "Production Associate", "3-7", "6.0"},
                    {"Cipla", "Quality Analyst", "3-6", "6.0"},
                    {"Lupin", "Research Associate", "3.5-8", "6.5"}
                };

            case "Mechanical":
                return new String[][] {
                    {"Tata Motors", "Graduate Engineer Trainee", "4-8", "6.0"},
                    {"Mahindra", "Mechanical Engineer", "4-8", "6.0"},
                    {"L&T", "Graduate Engineer Trainee", "4-9", "6.5"}
                };

            default:
                return new String[0][0];
        }
    }


    private void displayAllCompanies() {

        String[] branches = {
            "Computer Science",
            "BBA",
            "ECE",
            "Interior Designing",
            "Pharma",
            "Mechanical"
        };

        for (String branch : branches) {

            displayCompaniesByBranch(branch);

        }
    }


    private void displayCompaniesByBranch(String branch) {

        String[][] companies = getCompaniesByBranch(branch);

        if (companies.length == 0) {

            System.out.println("No companies found.");

            return;
        }

        System.out.println("\n========== " + branch.toUpperCase() + " ==========");

        System.out.printf("%-18s %-32s %-15s %-10s%n",
                "Company", "Job Role", "Salary (LPA)", "Min CGPA");

        System.out.println("--------------------------------------------------------------------------");

        for (String[] company : companies) {

            System.out.printf("%-18s %-32s %-15s %-10s%n",
                    company[0],
                    company[1],
                    company[2],
                    company[3]);

        }

        System.out.println("--------------------------------------------------------------------------");
        System.out.println("Total Companies: " + companies.length);
    }


    private void displayHighestPackage(String branch) {

        String[][] companies = getCompaniesByBranch(branch);

        if (companies.length == 0) {

            System.out.println("No companies found.");

            return;
        }

        String highestCompany = "";
        double highestPackage = 0;

        for (String[] company : companies) {

            String[] salaryRange = company[2].split("-");

            double maximumSalary = Double.parseDouble(salaryRange[1]);

            if (maximumSalary > highestPackage) {

                highestPackage = maximumSalary;
                highestCompany = company[0];

            }
        }

        System.out.println("\n========== HIGHEST SALARY PACKAGE ==========");
        System.out.println("Branch: " + branch);
        System.out.println("Company: " + highestCompany);
        System.out.println("Highest Package: " + highestPackage + " LPA");
    }
}
