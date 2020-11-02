package com.upgrad.mba.entities;

import javax.persistence.*;

@Entity
public class UserType {

    @Id
    @GeneratedValue
    private int userTypeId;

    @Column(length = 20, unique = true)
    private String userTypeName;

    public UserType() {
    }

    public UserType(int userTypeId, String userTypeName) {
        this.userTypeId = userTypeId;
        this.userTypeName = userTypeName;
    }

    public int getUserTypeId() {
        return userTypeId;
    }

    public void setUserTypeId(int userTypeId) {
        this.userTypeId = userTypeId;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    @Override
    public String toString() {
        return "UserType{" +
                "userTypeId=" + userTypeId +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
