
package com.campusplacement.service;

import com.campusplacement.model.Student;

public class EligibilityService {

    private static final double MINIMUM_CGPA = 6.0;
    private static final int MINIMUM_SEMESTER = 6;

    public boolean checkEligibility(Student student) {

        if (student == null) {
            System.out.println("Student not found.");
            return false;
        }

        if (student.getCgpa() >= MINIMUM_CGPA
                && student.getSemester() >= MINIMUM_SEMESTER) {

            System.out.println("Student is eligible for placements.");
            return true;
        }

        System.out.println("Student is not eligible for placements.");
        return false;
    }

    public void displayEligibilityCriteria() {
        System.out.println("\n===== ELIGIBILITY CRITERIA =====");
        System.out.println("Minimum CGPA: " + MINIMUM_CGPA);
        System.out.println("Minimum Semester: " + MINIMUM_SEMESTER);
    }
}
