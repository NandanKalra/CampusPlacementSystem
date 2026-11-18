
package com.campusplacement.model;

public class Resume {
    private String resumeTitle;
    private String filePath;
    private String summary;
    private String lastUpdated;

    public Resume() {}

    public Resume(String resumeTitle, String filePath,
                  String summary, String lastUpdated) {
        this.resumeTitle = resumeTitle;
        this.filePath = filePath;
        this.summary = summary;
        this.lastUpdated = lastUpdated;
    }

    public String getResumeTitle() {
        return resumeTitle;
    }

    public void setResumeTitle(String resumeTitle) {
        this.resumeTitle = resumeTitle;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void displayResume() {
        System.out.println("\n===== RESUME DETAILS =====");
        System.out.println("Title: " + resumeTitle);
        System.out.println("File Path: " + filePath);
        System.out.println("Summary: " + summary);
        System.out.println("Last Updated: " + lastUpdated);
    }
}
