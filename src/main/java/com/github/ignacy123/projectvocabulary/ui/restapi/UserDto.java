package com.github.ignacy123.projectvocabulary.ui.restapi;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.ignacy123.projectvocabulary.ui.domain.User;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by ignacy on 14.07.16.
 */
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String cookie;
    private User.Type type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCookie() {
        return cookie;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public User.Type getType() {
        return type;
    }

    public void setType(User.Type type) {
        this.type = type;
    }
}
