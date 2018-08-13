package com.example.nikola.nbateamwiki.utils;

import java.util.List;

public class Player {

    private String name;
    private int number;
    private int preferredPosition;
    private String info;
    private List<Integer> possiblePositions;

    public Player() {
    }

    public Player(String name, int number, int preferredPosition) {
        this.name = name;
        this.number = number;
        this.preferredPosition = preferredPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPreferredPosition() {
        return preferredPosition;
    }

    public void setPreferredPosition(int preferredPosition) {
        this.preferredPosition = preferredPosition;
    }

    public List<Integer> getPossiblePositions() {
        return possiblePositions;
    }

    public void setPossiblePositions(List<Integer> possiblePositions) {
        this.possiblePositions = possiblePositions;
    }

    public void addPossiblePosition(int position){

        possiblePositions.add(position);

    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
