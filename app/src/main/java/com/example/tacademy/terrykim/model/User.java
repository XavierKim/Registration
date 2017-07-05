package com.example.tacademy.terrykim.model;

/**
 * Created by Tacademy on 2017-06-30.
 */

public class User {


    int idx;
    String userEmail;
    String userPwd;
    String regDate;
    String hp;
    String os;
    String model;
    String uuid;
    String token;

    public User() {}

    public User(int idx, String userEmail, String userPwd, String regDate, String hp, String os, String model, String uuid, String token) {
        this.idx = idx;
        this.userEmail = userEmail;
        this.userPwd = userPwd;
        this.regDate = regDate;
        this.hp = hp;
        this.os = os;
        this.model = model;
        this.uuid = uuid;
        this.token = token;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getHp() {
        return hp;
    }

    public void setHp(String hp) {
        this.hp = hp;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "User{" +
                "idx=" + idx +
                ", userEmail='" + userEmail + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", regDate='" + regDate + '\'' +
                ", hp='" + hp + '\'' +
                ", os='" + os + '\'' +
                ", model='" + model + '\'' +
                ", uuid='" + uuid + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
