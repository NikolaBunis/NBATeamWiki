package com.example.nikola.nbateamwiki.utils;

public class TextHolder {
//a string to designate which activity the text is for
    public String type;
//variable to hold the actual text
    public String text;
//This string is for backup in case needed texts are too big for a single string variable.
    public String backupText;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getBackupText() {
        return backupText;
    }

    public void setBackupText(String backupText) {
        this.backupText = backupText;
    }
}
