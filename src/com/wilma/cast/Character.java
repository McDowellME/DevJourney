package com.wilma.cast;

public abstract class Character {
    private int id;
    private String name;
    private String catchPhrase;

    Character() {
    }

    Character(int id, String name, String catchphrase) {
        setId(id);
        setName(name);
        setCatchPhrase(catchphrase);
    }

    public String speak() {
        return "\"" + getCatchPhrase() + "\"";
    }

    public abstract String introduction();

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCatchPhrase() {
        return this.catchPhrase;
    }

    public void setCatchPhrase(String catchPhrase) {
        this.catchPhrase = catchPhrase;
    }
}