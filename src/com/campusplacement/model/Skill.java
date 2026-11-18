
package com.campusplacement.model;

public class Skill {
    private String skillName;
    private String proficiencyLevel;
    private int yearsOfExperience;

    public Skill() {}

    public Skill(String skillName, String proficiencyLevel,
                 int yearsOfExperience) {
        this.skillName = skillName;
        this.proficiencyLevel = proficiencyLevel;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public void displaySkill() {
        System.out.println(skillName + " | Level: " + proficiencyLevel
                + " | Experience: " + yearsOfExperience + " years");
    }
}
