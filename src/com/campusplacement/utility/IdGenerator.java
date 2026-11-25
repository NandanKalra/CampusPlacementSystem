
package com.campusplacement.utility;

public class IdGenerator {

    private static int userIdCounter = 1001;
    private static int studentIdCounter = 2001;

    public static  synchronized int generateUserId() {
        return userIdCounter++;
    }

    public static int generateStudentId() {
        return studentIdCounter++;
    }

    public static void displayCounters() {
        System.out.println("Next User ID: " + userIdCounter);
        System.out.println("Next Student ID: " + studentIdCounter);
    }
    public static void setNextStudentId(int nextId) {
    studentIdCounter = nextId;
}
}
