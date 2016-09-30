package com.tiy.RocketCheckIn;

/**
 * Created by Yehia830 on 9/30/16.
 */
public class LoginContainer {
    String error;
    User user;
    String email;
    String password;

    public LoginContainer() {
    }

    public LoginContainer(String errorMessage, User user) {
        this.error = errorMessage;
        this.user = user;
    }
    public LoginContainer(String email, String password){

    }


    public String getErrorMessage() {
        return error;
    }

    public void setErrorMessage(String errorMessage) {
        this.error = errorMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
