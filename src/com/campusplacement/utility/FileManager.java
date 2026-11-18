
package com.campusplacement.utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

    public void writeToFile(String filePath, String data) {

    File file = new File(filePath);

    try {
        File parent = file.getParentFile();

        if (parent != null) {
            parent.mkdirs();
        }

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(file, true))) {

            writer.write(data);
            writer.newLine();
        }

        System.out.println("Data saved successfully at: "
                + file.getAbsolutePath());

    } catch (IOException e) {
        System.out.println("Error saving data: " + e.getMessage());
    }
}

    public ArrayList<String> readFromFile(String filePath) {

        ArrayList<String> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {
                records.add(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return records;
    }

    public void clearFile(String filePath) {

        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(filePath, false))) {

            writer.write("");
            System.out.println("File cleared successfully.");

        } catch (IOException e) {
            System.out.println("Error clearing file: " + e.getMessage());
        }
    }
}
