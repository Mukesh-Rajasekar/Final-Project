package com.Project.UserAuthentication.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class UserAuthentication {
    @Id
    String userId;
    String password;


    public UserAuthentication() {
    }

    public UserAuthentication(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserAuthentication{" +
                "userId='" + userId + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
