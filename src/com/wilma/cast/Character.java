package com.wilma.cast;

public abstract class Character {
    private int id;
    private String name;
    private String catchPhrase;
    private String textFile;

    Character() {
    }

    Character(int id, String name, String catchphrase, String textFile) {
        setId(id);
        setName(name);
        setCatchPhrase(catchphrase);
        setTextFile(textFile);
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

    public String getTextFile() {
        return textFile;
    }

    public void setTextFile(String textFile) {
        this.textFile = textFile;
    }
}