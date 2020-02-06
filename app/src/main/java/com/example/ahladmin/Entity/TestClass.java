package com.example.ahladmin.Entity;

public class TestClass {

    private String status;
    private String playerName;
    private String minute;
    private String type;

    public TestClass(String status, String playerName, String minute, String type) {
        this.status = status;
        this.playerName = playerName;
        this.minute = minute;
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getMinute() {
        return minute;
    }

    public String getType() {
        return type;
    }
}
