
package com.campusplacement.repository;

import com.campusplacement.model.Student;
import com.campusplacement.utility.FileManager;
import com.campusplacement.utility.IdGenerator;

import java.util.ArrayList;

public class StudentRepository {

    private ArrayList<Student> students;
    private FileManager fileManager;

    private static final String FILE_PATH = "../data/students.txt";

    public StudentRepository() {
        students = new ArrayList<>();
        fileManager = new FileManager();
        loadStudents();
    }

    public boolean save(Student student) {

        if (student == null) {
            System.out.println("Invalid student record.");
            return false;
        }

        for (Student existingStudent : students) {

            if (existingStudent.getUserId() == student.getUserId()) {
                System.out.println("Student ID already exists.");
                return false;
            }

            if (existingStudent.getEmail().trim()
                    .equalsIgnoreCase(student.getEmail().trim())) {
                System.out.println("Student email already exists.");
                return false;
            }
        }

        students.add(student);

        String record = student.getUserId() + "|" +
                student.getName() + "|" +
                student.getEmail() + "|" +
                student.getPassword() + "|" +
                student.getBranch() + "|" +
                student.getSemester() + "|" +
                student.getCgpa();

        fileManager.writeToFile(FILE_PATH, record);

        return true;
    }

    public Student findById(int studentId) {

        for (Student student : students) {
            if (student.getUserId() == studentId) {
                return student;
            }
        }

        return null;
    }

    public ArrayList<Student> findAll() {
        return new ArrayList<>(students);
    }

    public boolean delete(int studentId) {

        boolean removed = students.removeIf(
                student -> student.getUserId() == studentId);

        if (removed) {
            rewriteFile();
        }

        return removed;
    }

    public int count() {
        return students.size();
    }

    private void loadStudents() {

        ArrayList<String> records = fileManager.readFromFile(FILE_PATH);
        int maxStudentId = 2000;

        for (String record : records) {

            try {
                String[] data = record.split("\\|");

                if (data.length != 7) {
                    continue;
                }

                Student student = new Student(
                        Integer.parseInt(data[0]),
                        data[1],
                        data[2],
                        data[3],
                        data[4],
                        Integer.parseInt(data[5]),
                        Double.parseDouble(data[6]));

                if (student.getUserId() > maxStudentId) {
                    maxStudentId = student.getUserId();
                }

                boolean duplicate = false;

                for (Student existingStudent : students) {

                    if (existingStudent.getUserId() == student.getUserId()
                            || existingStudent.getEmail().trim()
                                    .equalsIgnoreCase(student.getEmail().trim())) {

                        duplicate = true;
                        break;
                    }
                }

                if (!duplicate) {
                    students.add(student);
                }

            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid student record.");
            }
        }

        IdGenerator.setNextStudentId(maxStudentId + 1);
    }

    private void rewriteFile() {

        fileManager.clearFile(FILE_PATH);

        for (Student student : students) {

            String record = student.getUserId() + "|" +
                    student.getName() + "|" +
                    student.getEmail() + "|" +
                    student.getPassword() + "|" +
                    student.getBranch() + "|" +
                    student.getSemester() + "|" +
                    student.getCgpa();

            fileManager.writeToFile(FILE_PATH, record);
        }
    }
}
