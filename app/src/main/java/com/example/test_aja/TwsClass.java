package com.example.test_aja;

import android.os.Parcel;
import android.os.Parcelable;

public class TwsClass implements Parcelable {
    private String id;
    private String LastCheck;
    private String ResponseTime;
    private boolean State;

    public TwsClass(String id, String lastCheck, String responseTime, boolean state) {
        this.id = id;
        LastCheck = lastCheck;
        ResponseTime = responseTime;
        State = state;
    }
// Getter Methods

    protected TwsClass(Parcel in) {
        id = in.readString();
        LastCheck = in.readString();
        ResponseTime = in.readString();
        State = in.readByte() != 0;
    }

    public static final Creator<TwsClass> CREATOR = new Creator<TwsClass>() {
        @Override
        public TwsClass createFromParcel(Parcel in) {
            return new TwsClass(in);
        }

        @Override
        public TwsClass[] newArray(int size) {
            return new TwsClass[size];
        }
    };

    public String getId() {
        return id;
    }

    public String getLastCheck() {
        return LastCheck;
    }

    public String getResponseTime() {
        return ResponseTime;
    }

    public boolean getState() {
        return State;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(LastCheck);
        dest.writeString(ResponseTime);
        dest.writeByte((byte) (State ? 1 : 0));
    }
}
