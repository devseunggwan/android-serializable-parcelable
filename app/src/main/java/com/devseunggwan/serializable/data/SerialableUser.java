package com.devseunggwan.serializable.data;

import java.io.Serializable;

public class SerialableUser implements Serializable {
    String user_id;
    String user_name;
    String user_age;
    String user_address;

    public SerialableUser(String user_id, String user_name, String user_age, String user_address) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.user_age = user_age;
        this.user_address = user_address;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_age() {
        return user_age;
    }

    public void setUser_age(String user_age) {
        this.user_age = user_age;
    }

    public String getUser_address() {
        return user_address;
    }

    public void setUser_address(String user_address) {
        this.user_address = user_address;
    }
}
