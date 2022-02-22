package com.wilma.cast;

public class PlayableCharacter extends Character{
    private Education education;
    private boolean isCharismatic;
    private int luck;
    private int skill;
    private String description;

    PlayableCharacter() {
    }

    PlayableCharacter(int id, String name, String catchphrase) {
        super(id, name, catchphrase);
    }

    PlayableCharacter(int id, String name, String catchphrase, Education education,
                      boolean isCharismatic, int luck, int skill, String description) {
        this(id, name, catchphrase);
        setEducation(education);
        setCharismatic(isCharismatic);
        setLuck(luck);
        setSkill(skill);
        setDescription(description);
    }

    @Override
    public String introduction() {
        return getName() + ": \n"
                + "\"" + getCatchPhrase() + "\"" + "\n"
                + getDescription() + "\n"
                + "Player Attributes:" + "\n"
                + "Education - " + getEducation() + "\n"
                + "Charismatic - " + isCharismatic() + "\n"
                + "Luck Level - " + getLuck() + "\n"
                + "Coding Skill Level - " + getSkill();
    }

    public void makeChoice() {

    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public boolean isCharismatic() {
        return isCharismatic;
    }

    public void setCharismatic(boolean charismatic) {
        isCharismatic = charismatic;
    }

    public int getLuck() {
        return luck;
    }

    public void setLuck(int luck) {
        this.luck = luck;
    }

    public int getSkill() {
        return skill;
    }

    public void setSkill(int skill) {
        this.skill = skill;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}