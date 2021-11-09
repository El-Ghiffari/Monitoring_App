package com.example.test_aja;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {
    @Expose
    @SerializedName("tws")
    private TwsClass tws;
    @Expose
    @SerializedName("switching")
    private SwitchClass switching;
    @Expose
    @SerializedName("db")
    private DBclass db;
    @Expose
    @SerializedName("State")
    private boolean state;
    @Expose
    @SerializedName("serpis")
    private boolean serpis;

//    private boolean state;
//    //nanti bawah
//    private SwitchClass switching;
//    private TwsClass tws;
//    private DBclass db;


    public Post(boolean state, SwitchClass switching, TwsClass tws, DBclass db) {
        this.state = state;
        this.switching = switching;
        this.tws = tws;
        this.db = db;
    }

    public DBclass getDatabase() {
        return db;
    }

    public SwitchClass getSwitchClass() {
        return switching;
    }

    public TwsClass getTwsClass() {
        return tws;
    }

    public boolean isState() {
        return state;
    }

    public boolean isSerpis() {
        return serpis;
    }
}
