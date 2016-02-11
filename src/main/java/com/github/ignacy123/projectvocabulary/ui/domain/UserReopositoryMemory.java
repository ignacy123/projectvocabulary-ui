package com.github.ignacy123.projectvocabulary.ui.domain;

/**
 * Created by ignacy on 11.02.16.
 */
public class UserReopositoryMemory implements UserRepository{

    @Override
    public boolean isEmailUnique(String email) {
        return true;
    }

    @Override
    public User saveUser(User user) {
        return user;
    }
}
