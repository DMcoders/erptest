package com.example.erp01.model;

public class User {

    private Integer userID;

    private String passWord;

    private String userName;

    private String userPhone;

    private String userCardID;

    private String userNote;

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public User(String userName, String passWord, String userPhone, String userCardID, String userNote) {
        this.userName = userName;
        this.passWord = passWord;
        this.userPhone = userPhone;
        this.userCardID = userCardID;
        this.userNote = userNote;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserCardID() {
        return userCardID;
    }

    public void setUserCardID(String userCardID) {
        this.userCardID = userCardID;
    }

    public String getUserNote() {
        return userNote;
    }

    public void setUserNote(String userNote) {
        this.userNote = userNote;
    }
}
