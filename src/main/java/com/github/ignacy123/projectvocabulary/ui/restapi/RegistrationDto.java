package com.github.ignacy123.projectvocabulary.ui.restapi;

import com.github.ignacy123.projectvocabulary.ui.domain.User;

/**
 * Created by ignacy on 19.05.16.
 */
public class RegistrationDto {
    private String login;

    private String password;

    private String email;

    private User.Type type;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User.Type getType() {
        return type;
    }

    public void setType(User.Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "RegistrationDto{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }
}
