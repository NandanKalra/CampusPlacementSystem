
package com.campusplacement.service;

import com.campusplacement.model.Student;
import com.campusplacement.repository.StudentRepository;

import java.util.ArrayList;

public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService() {
        studentRepository = new StudentRepository();
    }

    public boolean addStudent(Student student) {

        if (student == null) {
            System.out.println("Invalid student data.");
            return false;
        }

        boolean saved = studentRepository.save(student);

        if (saved) {
            System.out.println("Student saved successfully.");
        }

        return saved;
    }

    public Student findStudentById(int studentId) {
        return studentRepository.findById(studentId);
    }

    public int countStudentsByBranch(String branch) {

        int count = 0;

        if (branch == null) {
            return count;
        }

        for (Student student : studentRepository.findAll()) {

            if (student.getBranch() != null &&
                student.getBranch().equalsIgnoreCase(branch)) {
                count++;
            }
        }

        return count;
    }

    public void displayStudentCountByBranch(String branch) {

        int count = countStudentsByBranch(branch);

        System.out.println("\n===== BRANCH STUDENT REPORT =====");
        System.out.println("Branch: " + branch);
        System.out.println("Total Students: " + count);
    }

    public boolean deleteStudent(int studentId) {

        boolean deleted = studentRepository.delete(studentId);

        if (deleted) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }

        return deleted;
    }

    public ArrayList<Student> getStudents() {
        return studentRepository.findAll();
    }
}
