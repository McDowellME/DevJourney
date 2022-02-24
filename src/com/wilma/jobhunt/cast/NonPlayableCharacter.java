package com.wilma.jobhunt.cast;

public class NonPlayableCharacter extends Character{
    private String dialogue;
    private String role;

    NonPlayableCharacter() {
    }

    NonPlayableCharacter(int id, String name, String catchphrase, String textFile) {
        super(id, name, catchphrase, textFile);
    }

    NonPlayableCharacter(int id, String name, String catchphrase, String textFile, String dialogue, String role) {
        this(id, name, catchphrase, textFile);
        setDialogue(dialogue);
        setRole(role);
    }

    @Override
    public String introduction() {
        return "You've met " + getName() + ", " + getRole() + ". \n" +
                "\"" + getCatchPhrase() + "\" \n\n" +
                "\"" + getDialogue() + "\"";
    }

    public String getDialogue() {
        return dialogue;
    }

    public void setDialogue(String dialogue) {
        this.dialogue = dialogue;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": id=" + getId() + ", name=" + getName()
                + ", catchphrase=" + getCatchPhrase() + ", dialogue=" + getDialogue()
                + ", role=" + getRole();
    }

}