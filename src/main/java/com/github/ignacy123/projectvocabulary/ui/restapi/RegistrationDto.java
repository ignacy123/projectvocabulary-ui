package com.github.ignacy123.projectvocabulary.ui.restapi;

import com.github.ignacy123.projectvocabulary.ui.domain.Role;
import com.github.ignacy123.projectvocabulary.ui.domain.User;

/**
 * Created by ignacy on 19.05.16.
 */
public class RegistrationDto {
    private String firstName;

    private String lastName;

    private String password;

    private String email;

    private Role role;

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName; }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type=" + type +
                '}';
    }
}
