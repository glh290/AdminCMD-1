package com.admincmd.api.entity;

public enum GameMode {
    
    SURVIVAL(0),
    CREATIVE(1),
    ADVENTURE(2),
    SPECTATOR(3);
    
    private int value;
    
    private GameMode(int value) {
        this.value = value;
    }

}
