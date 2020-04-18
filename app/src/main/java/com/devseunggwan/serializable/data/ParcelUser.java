package com.devseunggwan.serializable.data;

import android.os.Parcel;
import android.os.Parcelable;

public class ParcelUser implements Parcelable {

    public String user_id;
    public String user_name;
    public String user_age;
    public String user_address;

    public ParcelUser() {
    }

    public ParcelUser(Parcel in) {
        user_id = in.readString();
        user_name = in.readString();
        user_age = in.readString();
        user_address = in.readString();
    }

    public static final Creator<ParcelUser> CREATOR = new Creator<ParcelUser>() {
        @Override
        public ParcelUser createFromParcel(Parcel in) {
            return new ParcelUser(in);
        }

        @Override
        public ParcelUser[] newArray(int size) {
            return new ParcelUser[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(user_id);
        dest.writeString(user_name);
        dest.writeString(user_age);
        dest.writeString(user_address);
    }
}
