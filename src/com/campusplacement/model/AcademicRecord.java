
package com.campusplacement.model;

import java.util.HashMap;
import java.util.Map;

public class AcademicRecord {
    private String degree;
    private String university;
    private int passingYear;
    private HashMap<String, Double> subjectMarks;

    public AcademicRecord() {
        subjectMarks = new HashMap<>();
    }

    public AcademicRecord(String degree, String university, int passingYear) {
        this.degree = degree;
        this.university = university;
        this.passingYear = passingYear;
        this.subjectMarks = new HashMap<>();
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public int getPassingYear() {
        return passingYear;
    }

    public void setPassingYear(int passingYear) {
        this.passingYear = passingYear;
    }

    public void addSubjectMarks(String subject, double marks) {
        subjectMarks.put(subject, marks);
    }

    public HashMap<String, Double> getSubjectMarks() {
        return subjectMarks;
    }

    public double calculateAverageMarks() {
        if (subjectMarks.isEmpty()) {
            return 0.0;
        }

        double total = 0;

        for (double marks : subjectMarks.values()) {
            total += marks;
        }

        return total / subjectMarks.size();
    }

    public void displayAcademicRecord() {
        System.out.println("\n===== ACADEMIC RECORD =====");
        System.out.println("Degree: " + degree);
        System.out.println("University: " + university);
        System.out.println("Passing Year: " + passingYear);

        for (Map.Entry<String, Double> entry : subjectMarks.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Average Marks: " + calculateAverageMarks());
    }
}
