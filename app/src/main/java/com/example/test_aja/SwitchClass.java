package com.example.test_aja;

public class SwitchClass {
    private String id;
    private String LastCheck;
    private String ResponseTime;
    private boolean State;

    public SwitchClass(String id, String lastCheck, String responseTime, boolean state) {
        this.id = id;
        LastCheck = lastCheck;
        ResponseTime = responseTime;
        State = state;
    }

    public String getId() {
        return id;
    }

    public String getLastCheck() {
        return LastCheck;
    }

    public String getResponseTime() {
        return ResponseTime;
    }

    public boolean isState() {
        return State;
    }
}
