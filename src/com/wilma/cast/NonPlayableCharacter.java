package com.wilma.cast;

public class NonPlayableCharacter extends Character{
    private String dialogue;
    private String role;
    private int event;

    NonPlayableCharacter() {
    }

    NonPlayableCharacter(int id, String name, String catchphrase) {
        super(id, name, catchphrase);
    }

    NonPlayableCharacter(int id, String name, String catchphrase, String dialogue, String role, int event) {
        this(id, name, catchphrase);
        setDialogue(dialogue);
        setRole(role);
        setEvent(event);
    }

    @Override
    public void speak() {

    }
    @Override
    public String introduction() {
        return "You've met " + getName() + ", " + getRole() + ".";
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

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + ": id=" + getId() + ", name=" + getName()
                + ", catchphrase=" + getCatchPhrase() + ", dialogue=" + getDialogue()
                + ", role=" + getRole() + ", event=" + getEvent();
    }

}