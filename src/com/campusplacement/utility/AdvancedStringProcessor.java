
package com.campusplacement.utility;

public class AdvancedStringProcessor {

    public String reverseString(String input) {
        if (input == null) {
            return "";
        }

        return new StringBuilder(input).reverse().toString();
    }

    public int countWords(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        return input.trim().split("\\s+").length;
    }

    public String formatEmail(String email) {
        if (email == null) {
            return "";
        }

        return email.trim().toLowerCase();
    }

    public String extractInitials(String fullName) {
        if (fullName == null || fullName.trim().isEmpty()) {
            return "";
        }

        String[] words = fullName.trim().split("\\s+");
        StringBuilder initials = new StringBuilder();

        for (String word : words) {
            initials.append(Character.toUpperCase(word.charAt(0)));
        }

        return initials.toString();
    }

    public boolean containsKeyword(String text, String keyword) {
        if (text == null || keyword == null) {
            return false;
        }

        return text.toLowerCase().contains(keyword.toLowerCase());
    }
}
