package com.example.test_aja;

import android.os.Parcel;
import android.os.Parcelable;

public class DBclass implements Parcelable {
    private String id;
    private String LastCheck;
    private String ResponseTime;
    private boolean State;

    public DBclass(String id, String lastCheck, String responseTime, boolean state) {
        this.id = id;
        LastCheck = lastCheck;
        ResponseTime = responseTime;
        State = state;
    }

    protected DBclass(Parcel in) {
        id = in.readString();
        LastCheck = in.readString();
        ResponseTime = in.readString();
        State = in.readByte() != 0;
    }

    public static final Creator<DBclass> CREATOR = new Creator<DBclass>() {
        @Override
        public DBclass createFromParcel(Parcel in) {
            return new DBclass(in);
        }

        @Override
        public DBclass[] newArray(int size) {
            return new DBclass[size];
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

    public boolean isState() {
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
