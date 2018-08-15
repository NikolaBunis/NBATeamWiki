package com.example.nikola.nbateamwiki.utils;

import java.util.List;

public class Player {

    public String name;
    public int number;
    public int preferredPosition;
    public String info;
    public List<Integer> possiblePositions;

    public Player() {
    }

    public Player(String name, int number, int preferredPosition) {
        this.name = name;
        this.number = number;
        this.preferredPosition = preferredPosition;
    }

    @Override
    public String toString() {

        String prefPosition = "";

        switch (preferredPosition){
            case 1: prefPosition = "Point Guard"; break;
            case 2: prefPosition = "Shooting Guard"; break;
            case 3: prefPosition = "Small Forward"; break;
            case 4: prefPosition = "Power Forward"; break;
            case 5: prefPosition = "Center"; break;
        }


        return number + ". " + name + " - preferred position: " + prefPosition;
    }
}
