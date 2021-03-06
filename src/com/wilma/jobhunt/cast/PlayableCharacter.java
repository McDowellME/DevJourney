package com.wilma.jobhunt.cast;

public class PlayableCharacter extends Character {
    private Education education;
    private boolean isCharismatic;
    private int luck;
    private int skill;


    PlayableCharacter(int id, String name, String catchphrase, String textFile) {
        super(id, name, catchphrase, textFile);
    }

    public PlayableCharacter(int id, String name, String catchphrase, String textFile, Education education,
                      boolean isCharismatic, int luck, int skill) {
        this(id, name, catchphrase, textFile);
        setEducation(education);
        setCharismatic(isCharismatic);
        setLuck(luck);
        setSkill(skill);
    }

    @Override
    public String introduction() {
        return getName() + ": \n"
                + "\"" + getCatchPhrase() + "\"" + "\n"
                + "Player Attributes:" + "\n"
                + "Education - " + getEducation() + "\n"
                + "Charismatic - " + isCharismatic() + "\n"
                + "Luck Level - " + getLuck() + "\n"
                + "Coding Skill Level - " + getSkill();
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
}